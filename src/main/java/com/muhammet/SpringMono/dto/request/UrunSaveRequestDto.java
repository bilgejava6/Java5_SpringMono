package com.muhammet.SpringMono.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UrunSaveRequestDto {
    Long id;
    String ad;
    String fiyat;
    String kdv;
    String barkod;

}
