package com.capstone.tealeaf.database.entity;
// Entities are where you connect the database tables to your Java Project.

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity     // Spring Boot uses this to show that it's an entity.
@ToString   // Useful for logging, because it shows the information in a human readable way.
            // log.debug(order.toString()) would print out values
@NoArgsConstructor      // Order order = new Order();
@AllArgsConstructor     // Order order = new Order(user_id, order_date);

@Table(name = "orders")     // Lets Spring Boot know this is a representation of a table in your database.
                            // Name refers to the name of your table directly.
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    // Links column with variable on line below.
    private Integer id;     // Encapsulation - Your code doesn't get messed up on accident

    @Column(name = "order_date", columnDefinition = "DATE") // Column Definition for when the sql datatype is weird. (Datetime, Text etc.)
    private Date orderDate;

    // Where the chicken feet are is the "@ManyToOne", and the two straight lines are "@OneToMany"
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)     // Grabs information when needed?
        @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name="user_id", insertable = false, updatable = false)
    private Integer userId;
}
