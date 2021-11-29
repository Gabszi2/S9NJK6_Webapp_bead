package com.example.demo.controller;

import com.example.demo.service.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class DataCreateDto {

    @NotEmpty
    private String name;
    @Min(100)
    private Integer populance;

    public DataCreateDto() {
    }

    public DataCreateDto(Data data) {
        this.name = data.getName();
        this.populance = data.getPopulance();
    }
    public Data toData(){
        return new Data(null,name,populance);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulance() {
        return populance;
    }

    public void setPopulance(Integer populance) {
        this.populance = populance;
    }
}
