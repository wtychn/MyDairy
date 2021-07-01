package com.wtychn.mydairy.service;

import com.wtychn.mydairy.dao.RoleDAO;
import com.wtychn.mydairy.dao.User_RoleDAO;
import com.wtychn.mydairy.pojo.Role;
import com.wtychn.mydairy.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "roles")
public class RoleService {

    @Autowired
    RoleDAO roleDAO;
    @Autowired
    User_RoleDAO user_roleDAO;

    public Page4Navigator<Role> list(int start, int size, int navigatePages) {
        Sort sort = Sort.by("id");
        Page<Role> pageFromJPA = roleDAO.findAll(PageRequest.of(start, size, sort));
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public List<Role> list() {
        return roleDAO.findAll();
    }

    @CacheEvict(allEntries = true)
    public void add(Role bean) {
        roleDAO.save(bean);
    }

    @CacheEvict(allEntries = true)
    public void delete(int id) {
        roleDAO.deleteById(id);
        user_roleDAO.deleteByRole_id(id);
    }

    @CacheEvict(allEntries = true)
    public void update(Role role) {
        roleDAO.save(role);
    }

    @Cacheable(key = "'roles-one-'+ #p0")
    public Role get(int id) {
        return roleDAO.getOne(id);
    }
}
