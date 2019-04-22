package com.niezhiliang.spring.boot.mybatits.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/3/15 上午11:25
 */
@SpringBootApplication
@MapperScan(value = "com.niezhiliang.spring.boot.mybatits.plus.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
