package com.capstone.tealeaf.controller;

import com.capstone.tealeaf.database.dao.ProductDAO;
import com.capstone.tealeaf.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.util.*;

@Slf4j
@Controller
public class ProductController {

    @Autowired  //Bring in productDAO into said product controller
    private ProductDAO productDAO;

    @GetMapping("/menu")    // Sets the URL that the page is listening for. Once "/location" is added to the end of the URL, this function will run
    public ModelAndView menu() {
        ModelAndView response = new ModelAndView("product/menu"); // File structure inside your project
        // Here is where you add the stuff to make your page dynamic. (Adds database data to page)
        List<Product> products = productDAO.findAll();          // Finds and returns a list of all products.

        DecimalFormat df = new DecimalFormat("0.00");
        response.addObject("df", df);

        response.addObject("products", products);    // Send the products into your JSP page.

        return response;
    }

    @GetMapping("/product/{id}")    // Sets the URL that the page is listening for. Once "/location" is added to the end of the URL, this function will run
    public ModelAndView product(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("product/product"); // File structure inside your project
        DecimalFormat df = new DecimalFormat("0.00");
        response.addObject("df", df);

        // Here is where you add the stuff to make your page dynamic. (Adds database data to page)
        Product product = productDAO.findById(id); // Get's the Product we're looking for.
        response.addObject("product", product);

        return response;




    }
}
