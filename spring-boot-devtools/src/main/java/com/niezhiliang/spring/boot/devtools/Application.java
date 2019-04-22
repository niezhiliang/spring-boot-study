package com.niezhiliang.spring.boot.devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/22 上午11:36
 */
@SpringBootApplication
@RestController
public class Application {


    @RequestMapping(value = "/")
    public String hello() {
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
