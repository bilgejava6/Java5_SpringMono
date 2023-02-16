package com.muhammet.SpringMono.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class RegisterRequestDto {
    String username;
    String password;
    String repassword;
    String email;
}
