package com.capstone.tealeaf.database.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name ="product_id", insertable=false, updatable=false)
    private Integer productId;

    @Column(name ="order_id", insertable=false, updatable=false)
    private Integer orderId;

    @Column(name ="quantity")
    private Integer quantity;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;



}
