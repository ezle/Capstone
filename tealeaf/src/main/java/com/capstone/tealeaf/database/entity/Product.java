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
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name ="name")
    private String name;

    @Column(name ="price", columnDefinition="DECIMAL")      // For decimal use double(1 or 2 decimal places) or float(for bigger numbers)
    private Double price;       //"Double" is twice the size of float, Java is "double" sql "decimal"

    @Column(name ="description")
    private String description;

    @Column(name ="image_url")
    private String imageUrl;

    @ToString.Exclude                       // EAGER - grabs all the data
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)      // Take everything that relied on it with it, null spaces, removing data entirely from the database
    private List<OrderDetail> orderDetails;


}
