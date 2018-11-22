package com.zc.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhouchao
 * @Date: 2018/11/22 13:30
 * @Description:
 */
@SpringBootApplication
@RestController
public class DemoSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        throw  new RuntimeException();
//        return "hello spring security";
    }
}
