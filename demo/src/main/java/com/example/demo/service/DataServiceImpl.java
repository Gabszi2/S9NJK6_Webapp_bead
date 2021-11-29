package com.example.demo.service;

import com.example.demo.repository.DataRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DataServiceImpl implements DataService {
    private final DataRepository dataRepository;

    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public Data create(Data data) {
        return new Data(dataRepository.save(data.toEntity()));
    }

    @Override
    public void save(Data data)  {
        Optional<com.example.demo.repository.Data> dataOptional=dataRepository.findById(data.getId());
        if (dataOptional.isEmpty()){
            throw new NoSuchEntityException(data.getId());
        }
        dataRepository.save(data.toEntity());
    }

    @Override
    public Iterable<Data> getAllData() {
        List<Data> rv=new ArrayList<>();
        for (com.example.demo.repository.Data data:dataRepository.findAll()
             ) {
            rv.add(new Data(data));
        }
        return rv;
    }

    @Override
    public Data getByID(Long id) {
        Optional<com.example.demo.repository.Data> dataOptional=dataRepository.findById(id);
        if (dataOptional.isEmpty()){
            throw new NoSuchEntityException(id);
        }
        return new Data(dataOptional.get());
    }

    @Override
    public void delete(Long id) {
try {
    dataRepository.deleteById(id);
} catch (EmptyResultDataAccessException e) {
    throw new NoSuchEntityException(id);
}
    }

    @Override
    public Iterable<? extends Data> findByPopulanceGreatherThan(int populance) {
        return StreamSupport.stream(dataRepository.findAllByPopulanceGreaterThanOrderById(populance).spliterator(),false)
                .map(Data::new).collect(Collectors.toList());
    }
}
