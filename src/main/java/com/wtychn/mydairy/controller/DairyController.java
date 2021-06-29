package com.wtychn.mydairy.controller;


import com.wtychn.mydairy.pojo.Category;
import com.wtychn.mydairy.pojo.Dairy;
import com.wtychn.mydairy.pojo.User;
import com.wtychn.mydairy.service.CategoryService;
import com.wtychn.mydairy.service.DairyService;
import com.wtychn.mydairy.util.Page4Navigator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(value = "日记管理")
@RestController
public class DairyController {

    @Autowired
    DairyService dairyService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/dairysByCategory/{cid}")
    @ApiOperation(value = "按分类分页查询")
    public Page4Navigator<Dairy> listByCategory(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size, @PathVariable("cid") int cid, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        Category category = categoryService.get(cid);
        start = start < 0 ? 0 : start;
        return dairyService.listByCategory(start, size, 10, category, user);
    }

    @GetMapping("/dairys")
    @ApiOperation(value = "分页查询")
    public Page4Navigator<Dairy> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        start = start < 0 ? 0 : start;
        return dairyService.list(start, size, 10, user);
    }

    @PostMapping("/dairys")
    @ApiOperation(value = "添加数据")
    public Object add(Dairy bean) {
        dairyService.add(bean);
        return bean;
    }

    @DeleteMapping("/dairys/{id}")
    @ApiOperation(value = "删除数据")
    public String delete(@PathVariable("id") int id) {
        dairyService.delete(id);
        return null;
    }

    @GetMapping("/dairys/{id}")
    @ApiOperation(value = "按id查询")
    public Dairy get(@PathVariable("id") int id) {
        return dairyService.get(id);
    }

    @PutMapping("/dairys")
    @ApiOperation(value = "更新数据")
    public Object update(@RequestBody Dairy bean) {
        dairyService.update(bean);

        return bean;
    }
}
