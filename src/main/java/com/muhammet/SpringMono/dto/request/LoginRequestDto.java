package com.muhammet.SpringMono.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class LoginRequestDto {
    String username;
    String password;
}
