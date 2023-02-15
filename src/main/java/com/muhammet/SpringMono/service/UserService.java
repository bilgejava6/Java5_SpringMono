package com.muhammet.SpringMono.service;

import com.muhammet.SpringMono.dto.request.RegisterRequestDto;
import com.muhammet.SpringMono.dto.response.UserControllerFindAllResponseDto;
import com.muhammet.SpringMono.mapper.IUserMapper;
import com.muhammet.SpringMono.repository.IUserRepository;
import com.muhammet.SpringMono.repository.entity.User;
import com.muhammet.SpringMono.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends ServiceManager<User,Long> {
    private final IUserRepository repository;

    public UserService(IUserRepository repository){
        super(repository);
        this.repository = repository;
    }

    public Boolean register(RegisterRequestDto dto){
      User user = User.builder()
                .password(dto.getPassword())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .build();
      save(user);
      return true;
    }

    public Boolean registerMapper(RegisterRequestDto dto){
        save(IUserMapper.INSTANCE.toUser(dto));
        return true;
    }

    public List<UserControllerFindAllResponseDto> findAllResponseDtos(){
        /**
         * Boş List oluşturduk
         */
        List<UserControllerFindAllResponseDto> result = new ArrayList<>();
        /**
         * Tüm Kullanıcıların listesini çektik.
         */
        findAll().forEach(x->{
            /**
             * Dto nesnesini oluşturmak için her kullanıcının bilgilerini alarak builder ile
             * dto nesnesi yarattık ve  bu nesneyi listemize ekledik.
             */
//            result.add( UserControllerFindAllResponseDto.builder()
//                    .avatar(x.getAvatar())
//                    .id(x.getId())
//                    .username(x.getUsername())
//                    .build());
            result.add(IUserMapper.INSTANCE.userControllerFindAllResponseDtoFromUser(x));
        });
        return result;
    }
}
