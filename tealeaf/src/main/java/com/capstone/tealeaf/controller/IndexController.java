package com.capstone.tealeaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j              //Used for logging. Essentially a fancy System.Out.Println
@Controller         // Figures out what HTML file that you need

public class IndexController {

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView response = new ModelAndView("home");
        return response;
    }
}
