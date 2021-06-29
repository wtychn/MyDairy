package com.wtychn.mydairy.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(value = "页面跳转")
public class AdminPageController {
	@GetMapping(value="/admin")
	public String admin(){
		return "redirect:admin_category_list";
	}

	@GetMapping(value="/admin_category_list")
	public String listCategory(){
		return "admin/listCategory";
	}

	@GetMapping(value="/admin_category_edit")
	public String editCategory(){
		return "admin/editCategory";
	}

	@GetMapping(value="/admin_user_list")
	public String listUser(){
		return "admin/listUser";

	}
}
