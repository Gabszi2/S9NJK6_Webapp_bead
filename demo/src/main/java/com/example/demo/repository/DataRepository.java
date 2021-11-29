package com.example.demo.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

public interface DataRepository extends PagingAndSortingRepository<Data,Long> {
    Iterable<Data> findAllByPopulanceGreaterThanOrderById(int populance);

}
