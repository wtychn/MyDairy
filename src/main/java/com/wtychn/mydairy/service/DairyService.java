package com.wtychn.mydairy.service;

import com.wtychn.mydairy.dao.DairyDAO;
import com.wtychn.mydairy.es.dao.DairyESDAO;
import com.wtychn.mydairy.pojo.Category;
import com.wtychn.mydairy.pojo.Dairy;
import com.wtychn.mydairy.pojo.User;
import com.wtychn.mydairy.util.Page4Navigator;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DairyService {

    @Autowired
    DairyDAO dairyDAO;
    @Autowired
    DairyESDAO dairyESDAO;

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
        dairyESDAO.deleteById(id);
    }

    public void update(Dairy bean) {
        dairyDAO.save(bean);
        dairyESDAO.save(bean);
    }

    public void add(Dairy bean) {
        dairyDAO.save(bean);
        dairyESDAO.save(bean);
    }

    public List<Dairy> search(String keyword, int start, int size) {
        initDatabase2ES();
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders
                .functionScoreQuery(QueryBuilders.matchPhraseQuery("content", keyword),
                        ScoreFunctionBuilders.weightFactorFunction(100))
                .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                .setMinScore(10);
        Pageable pageable = PageRequest.of(start, size);
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
        Page<Dairy> page = dairyESDAO.search(searchQuery);
        return page.getContent();
    }

    private void initDatabase2ES() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Dairy> page = dairyESDAO.findAll(pageable);
        if (page.getContent().isEmpty()) {
            List<Dairy> dairies = dairyDAO.findAll();
            for (Dairy product : dairies) {
                dairyESDAO.save(product);
            }
        }
    }
}

