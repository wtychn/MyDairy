package com.wtychn.mydairy.service;

import com.wtychn.mydairy.dao.RoleDAO;
import com.wtychn.mydairy.pojo.Role;
import com.wtychn.mydairy.pojo.User;
import com.wtychn.mydairy.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Page4Navigator<Role> list(int start, int size, int navigatePages) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Page<Role> pageFromJPA = roleDAO.findAll(PageRequest.of(start, size, sort));
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public List<Role> list() {
        return roleDAO.findAll();
    }

    public void add(Role bean) {
        roleDAO.save(bean);
    }

    public void delete(int id) {
        roleDAO.deleteById(id);
    }

    public void update(Role role) {
        roleDAO.save(role);
    }

    public Role get(int id) {
        return roleDAO.getOne(id);
    }
}
