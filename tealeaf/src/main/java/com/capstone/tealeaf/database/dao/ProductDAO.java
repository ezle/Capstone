package com.capstone.tealeaf.database.dao;

import com.capstone.tealeaf.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    Product findById(Integer id);
    // Null if they cannot find the product

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Product findByName(String name);

    List<Product> findByPrice(Double price);
    // Return empty List if you cannot find the product with said price
    // Returns list of product with said price

    @Query(value ="SELECT * FROM products p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'));", nativeQuery = true)
    List<Product> findByNameLike(String name); // <-dynamic user from the search term   ^


}
