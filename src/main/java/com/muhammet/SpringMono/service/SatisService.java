package com.muhammet.SpringMono.service;


import com.muhammet.SpringMono.repository.ISatisRepository;
import com.muhammet.SpringMono.repository.entity.Satis;
import com.muhammet.SpringMono.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SatisService extends ServiceManager<Satis,Long> {
    private final ISatisRepository repository;
    public SatisService(ISatisRepository repository){
        super(repository);
        this.repository = repository;
    }

}
