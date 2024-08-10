package com.capstone.tealeaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j              //Used for logging. Essentially a fancy System.Out.Println
@Controller     // Figures out what HTML file that you need
@RequestMapping("/admin")
public class AdminController {
// what are you doing cray
    @GetMapping("/product")
    public ModelAndView product(){
         ModelAndView response = new ModelAndView("admin/product");
         return response;
     }

    @GetMapping("/location")
    public ModelAndView location(){
        ModelAndView response = new ModelAndView("admin/location");
        return response;
    }

}
