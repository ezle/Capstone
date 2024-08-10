package com.capstone.tealeaf.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity     // Spring Boot uses this to show that it's an entity.
@ToString   // Useful for logging, because it shows the information in a human readable way.
            // log.debug(order.toString()) would print out values
@NoArgsConstructor      // Order order = new Order();
@AllArgsConstructor     // Order-order = new Order(user_id, order_date);
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name ="email")
    private String email;        //VarChar use string

    @Column(name ="password")
    private String password;
    // THe light bulb moment - causes 405 error? infinite loop
    //ToString.Exclude - 90% of the time it will not cause an issue; would cause an infinite loop problem
    @ToString.Exclude                       // EAGER - grabs all the data
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)      // Take everything that relied on it with it, null spaces, removing data entirely from the database
    private List<Order> orders;

    @ToString.Exclude                       // EAGER - grabs all the data
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)      // Take everything that relied on it with it, null spaces, removing data entirely from the database
    private List<UserRole> userRoles;

}
