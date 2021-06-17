package com.wtychn.mydairy.controller;

import com.wtychn.mydairy.pojo.Category;
import com.wtychn.mydairy.service.CategoryService;
import com.wtychn.mydairy.util.Page4Navigator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(value = "分类管理")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    @ApiOperation(value = "分页查询")
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        return categoryService.list(start, size, 10);
    }

    @PostMapping("/categories")
    @ApiOperation(value = "添加数据")
    public Object add(Category bean) {
        categoryService.add(bean);
        return bean;
    }

    @DeleteMapping("/categories/{id}")
    @ApiOperation(value = "删除数据")
    public String delete(@PathVariable("id") int id) {
        categoryService.delete(id);
        return null;
    }

    @GetMapping("/categories/{id}")
    @ApiOperation(value = "按id查询")
    public Category get(@PathVariable("id") int id) {
        return categoryService.get(id);
    }

    @PutMapping("/categories/{id}")
    @ApiOperation(value = "更新数据")
    public Object update(Category bean, HttpServletRequest request) {
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);

        return bean;
    }
}
