package com.muhammet.SpringMono.service;

import com.muhammet.SpringMono.repository.IMusteriRepository;
import com.muhammet.SpringMono.repository.entity.Musteri;
import com.muhammet.SpringMono.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusteriService  extends ServiceManager<Musteri,Long> {

    /**
     * int sayi = 5;
     * Urun urun; // değişken tanımlama
     * urun = new Urun(); // Yeni nesne oluşturulur ve referansı değişkene atanır.
     *
     */
    /**
     * Repository nin enjekte edilme yöntemleri
     * 1- Field Injection -> @Autowired
     */
    //@Autowired
    //private IMusteriRepository repository;

    /**
     * 2- Constructor Injeciton
     *
     */
    private final IMusteriRepository repository;

    public MusteriService(IMusteriRepository repository){
        super(repository);
        this.repository = repository;
    }


    public boolean isExist(Long id){
        return repository.existsById(id);
    }

    public List<Musteri> adinaGoreGetir(String musteriadi){
        return repository.findByAd(musteriadi);
    }

    public List<Musteri> adVeAdreseGoreGetir(String ad,String adres){
        return repository.findAllByAdAndAdres(ad,adres);
    }

    public List<Musteri> findAllByAdLike(String ad){
        return repository.findAllByAdLike(ad);
    }

}
