package com.capstone.tealeaf.controller;

import com.capstone.tealeaf.database.dao.OrderDAO;
import com.capstone.tealeaf.database.dao.ProductDAO;
import com.capstone.tealeaf.database.entity.Order;
import com.capstone.tealeaf.database.entity.Product;
import com.capstone.tealeaf.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j              //Used for logging. Essentially a fancy System.Out.Println
@Controller     // Figures out what HTML file that you need
public class OrderController {


    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/orders")    // Sets the URL that the page is listening for. Once "/location" is added to the end of the URL, this function will run
    public ModelAndView orders() {
        ModelAndView response = new ModelAndView("orders/orders"); // File structure inside your project
        // Here is where you add the stuff to make your page dynamic. (Adds database data to page)
        return response;
    }

//    @GetMapping("/order/addToCart")
//    public ModelAndView addToCart(@RequestParam Integer productId){
//        ModelAndView response = new ModelAndView("order/orderdetail");

//        List<Map<String,Object>> orderDetails = orderDAO.getOrderDetails(orderId);
//        response.addObject("orderDetails", orderDetails);
//
//        Product product = productDAO.findById(productId);
//        User user = authenticatedUserUtilities.getCurrentUser();
//        // now we need to get the order from the database where the status is 'CART' and the user is the logged in user
//
//        // Find the order with status "CART" for the current user
//
//        Order order = orderDAO.findOrderInCartStatus(user.getId());
//        if (order == null) {
//            // If no such order exists, create a new one
//            order = new Order();
//            order.setUser(user);
//            order.setOrderDate(new Date()); // Set the order date to now
//            order.setStatus(("CART")); //newly addeed........
//            orderDAO.save(order);
//        }
//
//        // Check if the product is already in the cart
//        OrderDetail orderDetail = orderDetailDAO.findByOrderAndProduct(order.getId(), product.getId());
//        if (orderDetail == null) {
//            // If the product is not in the cart, add it
//            orderDetail = new OrderDetail();
//            orderDetail.setOrder(order);
//            orderDetail.setProduct(product);
//            orderDetail.setQty(1); // Start with a quantity of 1
//            orderDetailDAO.save(orderDetail);
//        } else {
//            // If the product is already in the cart, update the quantity
//            orderDetail.setQty(orderDetail.getQty() + 1);
//            orderDetailDAO.save(orderDetail);
//        }
//
//        response.setViewName("redirect:/order/orderdetail");
//        return response;
//
//
//    }
}
