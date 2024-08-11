package com.capstone.tealeaf.database.dao;

import com.capstone.tealeaf.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findById(Integer id);
    User findByEmailIgnoreCase(String username);
}
