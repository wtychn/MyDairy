package com.wtychn.mydairy.controller;

import com.wtychn.mydairy.pojo.Role;
import com.wtychn.mydairy.service.RoleService;
import com.wtychn.mydairy.util.Page4Navigator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(value = "角色管理")
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    @ApiOperation(value = "分页查询")
    public Page4Navigator<Role> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        return roleService.list(start, size, 10);
    }

    @PostMapping("/roles")
    @ApiOperation(value = "添加数据")
    public Object add(Role bean) {
        roleService.add(bean);
        return bean;
    }

    @DeleteMapping("/roles/{id}")
    @ApiOperation(value = "删除数据")
    public String delete(@PathVariable("id") int id) {
        roleService.delete(id);
        return null;
    }

    @GetMapping("/roles/{id}")
    @ApiOperation(value = "按id查询")
    public Role get(@PathVariable("id") int id) {
        return roleService.get(id);
    }

    @PutMapping("/roles/{id}")
    @ApiOperation(value = "更新数据")
    public Object update(Role bean, HttpServletRequest request) {
        String name = request.getParameter("name");
        bean.setName(name);
        roleService.update(bean);

        return bean;
    }

}
