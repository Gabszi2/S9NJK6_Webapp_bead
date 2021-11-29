package com.example.demo.service;



public class Data {
    private Long id;
    private String name;
    private Integer populance;

    public Data() {
    }

    public Data(Long id, String name, Integer populance) {
        this.id = id;
        this.name = name;
        this.populance = populance;
    }
    public Data(com.example.demo.repository.Data data) {
        this.id = data.getId();
        this.name = data.getName();
        this.populance = data.getPopulance();
    }
    public com.example.demo.repository.Data toEntity(){
        return new com.example.demo.repository.Data(id,name,populance);
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
