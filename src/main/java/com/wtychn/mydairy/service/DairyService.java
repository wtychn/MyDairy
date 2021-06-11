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

    List<Dairy> userDairies;

    public List<Dairy> listByUser(User user) {
        // 按日期倒序及当日时间正序排列
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "time"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "tid"));
        userDairies = dairyDAO.findByUser(user, Sort.by(orders));
        return userDairies;
    }

    public List<Dairy> listByTime(Date time) {
        return userDairies.stream()
                .filter(dairy -> dairy.getTime().equals(time))
                .collect(Collectors.toList());
    }

    // TODO: Dairy CRUD
}
