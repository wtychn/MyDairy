package com.wtychn.mydairy.es.dao;

import com.wtychn.mydairy.pojo.Dairy;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DairyESDAO extends ElasticsearchRepository<Dairy, Integer> {

}
