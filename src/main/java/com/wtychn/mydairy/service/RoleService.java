package com.wtychn.mydairy.service;

import com.wtychn.mydairy.dao.RoleDAO;
import com.wtychn.mydairy.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public List<Role> list() {
        return roleDAO.findAll();
    }

    public void add(Role bean) {
        roleDAO.save(bean);
    }

    public void delete(Role bean) {
        roleDAO.delete(bean);
    }

    public void update(Role role) {
        roleDAO.save(role);
    }

    public Role get(int id) {
        return roleDAO.getById(id);
    }
}
