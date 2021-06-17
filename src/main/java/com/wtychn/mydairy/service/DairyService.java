package com.wtychn.mydairy.service;

import com.wtychn.mydairy.dao.DairyDAO;
import com.wtychn.mydairy.pojo.Dairy;
import com.wtychn.mydairy.pojo.Role;
import com.wtychn.mydairy.pojo.User;
import com.wtychn.mydairy.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DairyService {

    @Autowired
    DairyDAO dairyDAO;

    List<Dairy> userDairies;

    public Page4Navigator<Dairy> list(int start, int size, int navigatePages, User user) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "time"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "tid"));
        Sort sort = Sort.by(orders);
        Page<Dairy> pageFromJPA = dairyDAO.findByUser(user, PageRequest.of(start, size, sort));
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

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
