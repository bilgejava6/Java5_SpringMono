package com.muhammet.SpringMono.mapper;

import com.muhammet.SpringMono.dto.request.UrunSaveRequestDto;
import com.muhammet.SpringMono.dto.request.UrunUpdateRequestDto;
import com.muhammet.SpringMono.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IUrunMapper {

    IUrunMapper INSTANCE = Mappers.getMapper(IUrunMapper.class);

    Urun urunFromDto(final UrunSaveRequestDto dto);

    Urun urunFromUpdateDto(final UrunUpdateRequestDto dto);
}
