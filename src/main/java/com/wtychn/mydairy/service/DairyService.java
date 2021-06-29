package com.wtychn.mydairy.service;

import com.wtychn.mydairy.dao.DairyDAO;
import com.wtychn.mydairy.pojo.Category;
import com.wtychn.mydairy.pojo.Dairy;
import com.wtychn.mydairy.pojo.User;
import com.wtychn.mydairy.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DairyService {

    @Autowired
    DairyDAO dairyDAO;

    public Page4Navigator<Dairy> list(int start, int size, int navigatePages, User user) {
        Page<Dairy> pageFromJPA = dairyDAO.findByUserOrderByTimeDesc(user, PageRequest.of(start, size));
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public Page4Navigator<Dairy> listByCategory(int start, int size, int navigatePages, Category category, User user) {
        Page<Dairy> pageFromJPA = dairyDAO.findByUserAndCategoryOrderByTimeDesc(user, category, PageRequest.of(start, size));
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public Dairy get(int id) {
        return dairyDAO.getOne(id);
    }

    public void delete(int id) {
        dairyDAO.deleteById(id);
    }

    public void update(Dairy bean) {
        dairyDAO.save(bean);
    }

    public void add(Dairy bean) {
        dairyDAO.save(bean);
    }
}
