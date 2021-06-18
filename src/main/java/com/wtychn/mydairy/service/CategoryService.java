package com.wtychn.mydairy.service;

import com.wtychn.mydairy.dao.CategoryDAO;
import com.wtychn.mydairy.pojo.Category;
import com.wtychn.mydairy.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Category> pageFromJPA = categoryDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public List<Category> list() {
        return categoryDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public void add(Category bean) {
        categoryDAO.save(bean);
    }

    public void delete(int id) {
        categoryDAO.deleteById(id);
    }

    public void update(Category bean) {
        categoryDAO.save(bean);
    }

    public Category get(int id) {
        return categoryDAO.findById(id).get();
    }


}
