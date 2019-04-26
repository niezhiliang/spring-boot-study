package com.niezhiliang.spring.boot.logs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/25 上午9:56
 */
@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);

        log.info("这是Info Level 日志");
        log.warn("这是Warm日志");
        log.error("这是Error Level 日志");
    }
}
