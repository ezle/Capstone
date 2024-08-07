package com.capstone.tealeaf.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "order_details")

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name ="product_id")
    private Integer productId;

    @Column(name ="order_id")
    private Integer orderId;

    @Column(name ="quantity")
    private Integer quantity;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "orders", nullable = true)
    private Order order;



}
