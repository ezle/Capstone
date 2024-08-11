package com.capstone.tealeaf.controller;

import com.capstone.tealeaf.database.dao.UserDAO;
import com.capstone.tealeaf.database.dao.UserRoleDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j              //Used for logging. Essentially a fancy System.Out.Println
@Controller     // Figures out what HTML file that you need
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserRoleDAO userRoleDAO;


    @GetMapping("/create")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("auth/signup");
        return response;
    }

}
