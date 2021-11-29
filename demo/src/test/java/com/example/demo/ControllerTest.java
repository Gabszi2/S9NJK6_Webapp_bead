package com.example.demo;

import com.example.demo.repository.Data;
import com.example.demo.repository.DataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DataRepository  dataRepository;
    @Test
     void noMainPage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is4xxClientError());
    }
    @Test
    void returnData() throws Exception {
        //Given
        Data data=new Data(1L,"asd",200);
        Iterable<Data> dataIterable=dataRepository.findAll();
        dataRepository.save(data);
        //When Than
        this.mockMvc.perform(get("/data")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.[0].name",is("asd"))).andExpect(jsonPath("$.[0].populance",is(200)));
    }
}
