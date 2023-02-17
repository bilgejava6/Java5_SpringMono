package com.muhammet.SpringMono.mvccontroller;

import com.muhammet.SpringMono.dto.request.UrunSaveRequestDto;
import com.muhammet.SpringMono.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.muhammet.SpringMono.constants.EndPoints.*;
@Controller
@RequestMapping(URUN)
@RequiredArgsConstructor
public class UrunMvcController {

    private final UrunService urunService;

    @GetMapping(INDEX)
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.setViewName("urun");

        return model;
    }

    // http://localhost:8080/v1/dev/urun/save
    @PostMapping(SAVE)
    public ModelAndView save(UrunSaveRequestDto dto){
        urunService.save(dto);
        return new ModelAndView("redirect:index");
    }

}
