package com.capstone.tealeaf.controller;

import com.capstone.tealeaf.database.dao.ProductDAO;
import com.capstone.tealeaf.database.entity.Product;
import com.capstone.tealeaf.form.CreateProductFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.util.List;

@Slf4j              //Used for logging. Essentially a fancy System.Out.Println
@Controller     // Figures out what HTML file that you need
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
// what are you doing cray

    @Autowired
    private ProductDAO productDAO;
    @GetMapping("/product")
    public ModelAndView product(){
         ModelAndView response = new ModelAndView("admin/product");

        DecimalFormat df = new DecimalFormat("0.00");
        response.addObject("df", df);

         List<Product> products = productDAO.findAll();
         response.addObject("products", products);
         return response;
     }

    @GetMapping("/location")
    public ModelAndView location(){
        ModelAndView response = new ModelAndView("admin/location");
        return response;
    }

    @GetMapping("/create-product")
    public ModelAndView create(){
        ModelAndView response = new ModelAndView("admin/create");


        return response;
    }

    @PostMapping("/create-product")
    public ModelAndView productSubmit(CreateProductFormBean form) {
        ModelAndView response = new ModelAndView("admin/create");

        response.addObject("form", form);

        Product product = productDAO.findById(form.getId());
        if (product == null) {
            product = new Product();
        }

        // Save product ---
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setImageUrl(form.getImageUrl());

        log.debug(product.toString());
        productDAO.save(product);
        response.setViewName("redirect:/menu");

        return response;
    }

}
