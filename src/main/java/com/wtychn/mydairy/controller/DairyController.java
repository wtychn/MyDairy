package com.wtychn.mydairy.controller;


import com.wtychn.mydairy.service.DairyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "日记管理")
@RestController
public class DairyController {

    @Autowired
    DairyService dairyService;


}
