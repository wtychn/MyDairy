package com.wtychn.mydairy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DairyServiceTest {

    @Autowired
    DairyService dairyService;

    @Test
    public void search() {
        System.out.println(dairyService.search("好日子", 0, 5));
    }
}