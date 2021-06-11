package com.wtychn.mydairy.dao;

import com.wtychn.mydairy.pojo.Dairy;
import com.wtychn.mydairy.pojo.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DairyDAO extends JpaRepository<Dairy, Integer> {
    List<Dairy> findByUser(User user, Sort sort);

    List<Dairy> findByUserAndTimeOrderByTid(User user, Date time);
}
