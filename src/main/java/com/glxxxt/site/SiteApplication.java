package com.glxxxt.site;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.glxxxt.site.dao")
public class SiteApplication {

    public static void main(String[] args) {

        SpringApplication.run(SiteApplication.class, args);
    }







}
