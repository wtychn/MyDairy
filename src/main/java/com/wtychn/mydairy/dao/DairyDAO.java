package com.wtychn.mydairy.dao;

import com.wtychn.mydairy.pojo.Category;
import com.wtychn.mydairy.pojo.Dairy;
import com.wtychn.mydairy.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DairyDAO extends JpaRepository<Dairy, Integer> {
    Page<Dairy> findByUserAndCategoryOrderByTimeDesc(User user, Category category, PageRequest pageRequest);

    Page<Dairy> findByUserOrderByTimeDesc(User user, PageRequest pageRequest);
}
