package com.wtychn.mydairy.dao;

import com.wtychn.mydairy.pojo.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface User_RoleDAO extends JpaRepository<User_Role, Integer> {
    @Transactional
    public void deleteByRole_id(int rid);
}
