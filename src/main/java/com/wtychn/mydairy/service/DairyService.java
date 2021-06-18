package com.wtychn.mydairy.service;

import com.wtychn.mydairy.dao.DairyDAO;
import com.wtychn.mydairy.pojo.Dairy;
import com.wtychn.mydairy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
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


    public List<Dairy> listByUser(User user) {
        // 按日期倒序及当日时间正序排列
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "time"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "tid"));
        return dairyDAO.findByUser(user, Sort.by(orders));
    }

    public List<Dairy> listByTime(Date time, User user) {
        return listByUser(user).stream()
                .filter(dairy -> dairy.getTime().equals(time))
                .collect(Collectors.toList());
    }

    public Dairy get(int id) {
        return dairyDAO.getById(id);
    }

    public void delete(Dairy bean) {
        dairyDAO.delete(bean);
    }

    public void set(Dairy bean) {
        dairyDAO.save(bean);
    }

    public void add(Dairy bean) {
        dairyDAO.save(bean);
    }
}
