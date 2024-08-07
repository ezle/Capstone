package com.capstone.tealeaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j              //Used for logging. Essentially a fancy System.Out.Println
@Controller     // Figures out what HTML file that you need
public class OrderController {
    @GetMapping("/orders")    // Sets the URL that the page is listening for. Once "/location" is added to the end of the URL, this function will run
    public ModelAndView orders() {
        ModelAndView response = new ModelAndView("orders/orders"); // File structure inside your project
        // Here is where you add the stuff to make your page dynamic. (Adds database data to page)
        return response;
    }
}
