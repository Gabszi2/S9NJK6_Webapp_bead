package com.example.demo.repository;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Data {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer populance;

    public Data(Long id, String name, Integer populance) {
        this.id = id;
        this.name = name;
        this.populance = populance;
    }

    public Data() {
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
