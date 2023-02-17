package com.muhammet.SpringMono.mvccontroller;

import com.muhammet.SpringMono.dto.request.UrunSaveRequestDto;
import com.muhammet.SpringMono.mvccontroller.models.UrunIndexModel;
import com.muhammet.SpringMono.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

import static com.muhammet.SpringMono.constants.EndPoints.*;
@Controller
@RequestMapping(URUN)
@RequiredArgsConstructor
public class UrunMvcController {

    private final UrunService urunService;

    @GetMapping(INDEX)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("urun");
        UrunIndexModel model = new UrunIndexModel();
        model.setTitle("Ürün İşlemleri");
        model.setMenulistesi(Arrays.asList("Ürün Ekleme","Ürün Listesi","Firma Ekleme","Stok Listesi"));
        model.setUrunlistesi(urunService.findAll());
        modelAndView.addObject("model",model);
        return modelAndView;
    }

    // http://localhost:8080/v1/dev/urun/save
    @PostMapping(SAVE)
    public ModelAndView save(UrunSaveRequestDto dto){
        urunService.save(dto);
        return new ModelAndView("redirect:index");
    }

}
