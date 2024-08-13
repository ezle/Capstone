package com.capstone.tealeaf.controller;

import com.capstone.tealeaf.database.dao.OrderDAO;
import com.capstone.tealeaf.database.dao.OrderDetailDAO;
import com.capstone.tealeaf.database.entity.Order;
import com.capstone.tealeaf.database.entity.OrderDetail;
import com.capstone.tealeaf.database.entity.User;
import com.capstone.tealeaf.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j                  // Used for logging. Essentially a fancy System.Out.Println
@Controller          // Figures out what HTML file that you need
public class CartController {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;


    @GetMapping("/mycart") // URL only not jsp - path for browser
    public ModelAndView viewCart() {
        ModelAndView response = new ModelAndView("orders/cart"); // This is file from jsp
        User user = authenticatedUserUtilities.getCurrentUser();

        Order order= orderDAO.findByStatusAndUserId("CART", user.getId());
        List<OrderDetail> orderDetails= orderDetailDAO.findByOrderId(order.getId());
        response.addObject("orderDetails", orderDetails);

        return response;
    }

    @GetMapping("/removeFromCart")
    public ModelAndView deleteProductFromCart(@RequestParam Integer orderDetailId, @RequestParam Integer orderId) { // Find it first
        ModelAndView response = new ModelAndView("orders/cart");
        OrderDetail orderDetail = orderDetailDAO.findById(orderDetailId);
        orderDetailDAO.delete(orderDetail);
        List<OrderDetail> orderDetails= orderDetailDAO.findByOrderId(orderId);
        response.addObject("orderDetails", orderDetails);
        return response;

    }



}
