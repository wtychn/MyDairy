package com.wtychn.mydairy.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class DairyServiceTest {

    @Autowired
    DairyService dairyService;

    @Test
    void search() {
        System.out.println(dairyService.search("好日子", 0, 5));
    }
}