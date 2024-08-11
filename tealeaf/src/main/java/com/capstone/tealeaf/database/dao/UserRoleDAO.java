package com.capstone.tealeaf.database.dao;

import com.capstone.tealeaf.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Integer>  {
    List<UserRole> findByUserId(Integer userId);
}
