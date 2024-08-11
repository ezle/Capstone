package com.capstone.tealeaf.controller;

import com.capstone.tealeaf.database.dao.UserDAO;
import com.capstone.tealeaf.database.dao.UserRoleDAO;
import com.capstone.tealeaf.database.entity.User;
import com.capstone.tealeaf.form.CreateAccountFormBean;
import com.capstone.tealeaf.security.AuthenticatedUserUtilities;
import com.capstone.tealeaf.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/create")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("auth/signup");


        return response;
    }

    @PostMapping("/sign-up")
    public ModelAndView signUpSubmit(CreateAccountFormBean form, HttpSession session){
        ModelAndView response = new ModelAndView("auth/signup");
        response.addObject("form", form);

        // save the user to the database
        User user = userService.createUser(form);
        response.setViewName("redirect:/");


        return response;

    }

}
