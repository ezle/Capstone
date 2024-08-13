package com.capstone.tealeaf.database.dao;

import com.capstone.tealeaf.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {
    Order findById(Integer id);
    // Always return 1 or zero "order"

    List<Order> findByStatus(String status);
    // Bay 2024 - "You have to think..."

    List<Order> findByUserId(Integer userId);


    Order findByStatusAndUserId(String status, Integer userId);
}
