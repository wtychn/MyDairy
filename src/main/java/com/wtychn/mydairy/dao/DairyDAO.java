package com.wtychn.mydairy.dao;

import com.wtychn.mydairy.pojo.Dairy;
import com.wtychn.mydairy.pojo.User;
import com.wtychn.mydairy.util.Page4Navigator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DairyDAO extends JpaRepository<Dairy, Integer> {
    List<Dairy> findByUser(User user, Sort sort);

    Page<Dairy> findByUser(User user, PageRequest pageRequest);
}
