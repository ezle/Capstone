package com.capstone.tealeaf.controller;

import com.capstone.tealeaf.database.dao.UserDAO;
import com.capstone.tealeaf.database.dao.UserRoleDAO;
import com.capstone.tealeaf.database.entity.User;
import com.capstone.tealeaf.form.CreateAccountFormBean;
import com.capstone.tealeaf.security.AuthenticatedUserUtilities;
import com.capstone.tealeaf.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/sign-up")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("auth/signup");


        return response;
    }

    @PostMapping("/sign-up")
    public ModelAndView signUpSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult){
        ModelAndView response = new ModelAndView("auth/signup");

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            response.addObject("form", form);

            return response;

        } else {

            User user = userService.createUser(form);
//            authenticatedUserUtilities.manualAuthentication(session, form.getEmail(), form.getPassword());
            response.setViewName("redirect:/");


        }

        // save the user to the database
        User user = userService.createUser(form);
        response.setViewName("redirect:/");


        return response;

    }

    // Login

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String error){
        ModelAndView response = new ModelAndView("auth/login");

        return response;

    }

    @PostMapping("/login")
    public ModelAndView loginSubmit(){
        ModelAndView response = new ModelAndView("auth/login");
        response.setViewName("redirect:/");
        return response;

    }


}
