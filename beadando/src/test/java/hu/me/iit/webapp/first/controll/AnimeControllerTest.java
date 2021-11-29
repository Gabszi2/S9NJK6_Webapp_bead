package hu.me.iit.webapp.first.controll;

import hu.me.iit.webapp.first.repository.Anime;
import hu.me.iit.webapp.first.repository.AnimeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;



import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AnimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    public void shouldNoMainPage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void shoudReturnAnime() throws Exception {
        //Given
        Anime anime=new Anime(1L,"asd",10);

        Iterable<Anime> animeIterable=animeRepository.findAll();
        animeRepository.save(anime);

        //When Than
        this.mockMvc.perform(get("/anime")).andDo(print()).andExpect(status().isOk()).
                andExpect(jsonPath("$.[0].name",is("asd"))).
                andExpect(jsonPath("$.[0].time",is(10)));

    }
    @Test
    public void shoudReturnAnime2() throws Exception {
        //Given
        Anime anime=new Anime(1L,"2",30);

        Iterable<Anime> animeIterable=animeRepository.findAll();
        animeRepository.save(anime);

        //When Than
        this.mockMvc.perform(get("/anime")).andDo(print()).andExpect(status().isOk()).
                andExpect(jsonPath("$.[0].name",is("2"))).
                andExpect(jsonPath("$.[0].time",is(30)));

    }
}