package com.muhammet.SpringMono.service;

import com.muhammet.SpringMono.repository.IUrunRepository;
import com.muhammet.SpringMono.repository.entity.Urun;
import com.muhammet.SpringMono.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UrunService extends ServiceManager<Urun,Long> {
    public UrunService(IUrunRepository repository){
        super(repository);
    }

}
