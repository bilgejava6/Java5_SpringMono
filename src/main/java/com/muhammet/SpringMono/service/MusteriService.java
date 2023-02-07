package com.muhammet.SpringMono.service;

import com.muhammet.SpringMono.repository.IMusteriRepository;
import com.muhammet.SpringMono.repository.entity.Musteri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusteriService {

    @Autowired
    private IMusteriRepository repository;

    public void save(Musteri musteri){
        System.out.println("Müşteri Service SAVE ÇAlıştı");
        repository.save(musteri);
    }

    public void saveAll(List<Musteri> musteriList){
        repository.saveAll(musteriList);
    }

    /**
     * Update için özellikle bir update komutu yoktur. Eğer Entity içinde ID bilgisi
     * bulunuyor ise, ilgili id kaydı için entity içindeki yeni değerler değiştirilir.
     * @param musteri
     */
    public void update(Musteri musteri){
        repository.save(musteri);
    }
    public void delete(Musteri musteri){
        repository.delete(musteri);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Musteri> findAll(){
        return repository.findAll();
    }

    public Optional<Musteri> findById(Long id){
        return repository.findById(id);
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
