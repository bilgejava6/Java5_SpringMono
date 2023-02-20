package com.muhammet.SpringMono.service;

import com.muhammet.SpringMono.dto.request.UrunSaveRequestDto;
import com.muhammet.SpringMono.dto.request.UrunUpdateRequestDto;
import com.muhammet.SpringMono.mapper.IUrunMapper;
import com.muhammet.SpringMono.repository.IUrunRepository;
import com.muhammet.SpringMono.repository.entity.Urun;
import com.muhammet.SpringMono.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UrunService extends ServiceManager<Urun,Long> {
    public UrunService(IUrunRepository repository){
        super(repository);
    }

    public void save(UrunSaveRequestDto dto){
        save(IUrunMapper.INSTANCE.urunFromDto(dto));
    }

    public void update(UrunUpdateRequestDto dto){
        update(IUrunMapper.INSTANCE.urunFromUpdateDto(dto));
    }
}
