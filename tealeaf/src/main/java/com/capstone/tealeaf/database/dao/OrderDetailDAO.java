package com.capstone.tealeaf.database.dao;

import com.capstone.tealeaf.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
    OrderDetail findById(Integer id);

    List<OrderDetail> findByProductId(Integer productId);

    List<OrderDetail> findByOrderId(Integer orderId);
}
