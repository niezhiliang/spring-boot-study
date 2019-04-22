package com.niezhiliang.spring.boot.mybatits.plus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/3/16 上午11:41
 */
@Configuration
public class MybatisPlusConfig {


    /**
     * mybatits puls 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}