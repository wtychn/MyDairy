package com.wtychn.mydairy.dao;

import com.wtychn.mydairy.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
