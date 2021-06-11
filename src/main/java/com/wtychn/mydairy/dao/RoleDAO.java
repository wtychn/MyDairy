package com.wtychn.mydairy.dao;

import com.wtychn.mydairy.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Integer> {
}
