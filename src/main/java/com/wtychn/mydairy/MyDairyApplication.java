package com.wtychn.mydairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackages = {"com.wtychn.mydairy.dao", "com.wtychn.mydairy.pojo"})
public class MyDairyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDairyApplication.class, args);
    }

}
