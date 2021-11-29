package com.example.demo.controller;

import com.example.demo.service.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class DataDto {
    private Long id;
    @NotEmpty
    private String name;
    @Min(100)
    private Integer populance;

    public DataDto() {
    }

    public DataDto(Data  data) {
        this.id = data.getId();
        this.name = data.getName();
        this.populance = data.getPopulance();
    }
public Data toData(){
        return new Data(id,name,populance);
}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
