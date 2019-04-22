package com.niezhiliang.spring.boot.mybatits;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/22 下午3:04
 */
@SpringBootApplication
@MapperScan(value = "com.niezhiliang.spring.boot.mybatits.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
