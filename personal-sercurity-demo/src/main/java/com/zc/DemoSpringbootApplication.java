package com.zc;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    }
    @GetMapping("/user")
    public String user(){
        Map map = new HashMap();
        map.put("name","test");
        map.put("age",24);
        map.put("sex","男");
        return JSON.toJSONString(map);
    }
}
