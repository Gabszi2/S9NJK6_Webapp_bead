package com.example.demo.controller;

import com.example.demo.service.Data;
import com.example.demo.service.DataService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }
    @GetMapping
    public Iterable<DataDto> getAllData(){
        List<DataDto> dataDtoList=new ArrayList<>();
        for (Data data: dataService.getAllData()
             ) {
            dataDtoList.add(new DataDto(data));
        }
        return dataDtoList;
    }
    @GetMapping("/{id}")
    public DataDto getById(@PathVariable("id") Long id){
        return new DataDto(dataService.getByID(id));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        dataService.delete(id);
    }
    @PostMapping(consumes = "application/json")
    public DataDto save(@RequestBody @Valid DataCreateDto dataCreateDto){
return new DataDto(dataService.create(dataCreateDto.toData()));
    }
@PutMapping
    public void save(@RequestBody @Valid DataDto dataDto){
       dataService.save(dataDto.toData());
}
@GetMapping("/findByPopulanceGt")
    public Iterable<DataDto> findBiggerPopulance(@RequestParam("populance") int populance){
        List<DataDto> dataDtoList=new ArrayList<>();
    for (Data data: dataService.findByPopulanceGreatherThan(populance)
         ) {
        dataDtoList.add(new DataDto(data));
    }
    return dataDtoList;
}
}
