package com.capstone.tealeaf.controller;

import com.capstone.tealeaf.database.dao.*;
import com.capstone.tealeaf.database.entity.Order;
import com.capstone.tealeaf.database.entity.OrderDetail;
import com.capstone.tealeaf.database.entity.Product;
import com.capstone.tealeaf.database.entity.User;
import com.capstone.tealeaf.form.CreateAccountFormBean;
import com.capstone.tealeaf.security.AuthenticatedUserUtilities;
import com.capstone.tealeaf.service.UserService;
import jakarta.servlet.http.HttpSession;
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

import java.util.Date;


@Slf4j              //Used for logging. Essentially a fancy System.Out.Println
@Controller         // Figures out what HTML file that you need
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @GetMapping("/sign-up")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("auth/signup");  //This is a jsp page


        return response;
    }

    @PostMapping("/sign-up")
    public ModelAndView signUpSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult, HttpSession session){
        ModelAndView response = new ModelAndView("auth/signup");

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            response.addObject("form", form);

            return response;

        } else {
            // save the user to the database
            User user = userService.createUser(form);
            authenticatedUserUtilities.manualAuthentication(session, form.getEmail(), form.getPassword());
            response.setViewName("redirect:/");


        }


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

    @GetMapping("/order/addToCart") // URL to link
    public ModelAndView addToCart(@RequestParam Integer productId){
        ModelAndView response = new ModelAndView();

        Product product = productDAO.findById(productId);
        User user = authenticatedUserUtilities.getCurrentUser();

        // Find the order with status "CART" for the current user
        Order order = orderDAO.findByStatusAndUserId("CART", user.getId());
        if (order == null) {
            // If no such order exists, create a new one
            order = new Order();
            order.setUser(user);
            order.setOrderDate(new Date());
            order.setStatus("CART");
            orderDAO.save(order);
        }

        // Check if the product is already in the cart
        OrderDetail orderDetail = orderDetailDAO.findByOrderIdAndProductId(order.getId(), product.getId());
        if (orderDetail == null) {
            // If the product is not in the cart, add it
            orderDetail = new OrderDetail();
            orderDetail.setOrder(order); // Linking order detail to the order
            orderDetail.setProduct(product); // Select product that links to the order
            orderDetail.setQuantity(1); // Start with a quantity of 1
            orderDetailDAO.save(orderDetail);
        } else {
            // If the product is already in the cart, update the quantity
            orderDetail.setQuantity(orderDetail.getQuantity() + 1);
            orderDetailDAO.save(orderDetail);
        }

        response.setViewName("redirect:/mycart");
        return response;
    }



}
