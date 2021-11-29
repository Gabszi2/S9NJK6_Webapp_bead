package com.example.demo.service;

public interface DataService {
    Data create(Data data);
    void save(Data data);
    Iterable<Data> getAllData();
    Data getByID(Long id);
    void delete(Long id);
Iterable<? extends Data> findByPopulanceGreatherThan(int populance);
}
