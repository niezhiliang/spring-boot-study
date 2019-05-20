package com.niezhiliang.spring.boot.current.limite.controller;

import com.niezhiliang.spring.boot.current.limite.annotation.Limit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/20 上午10:26
 */
@RequestMapping(value = "/")
@RestController
public class IndexController {

    /**
     * 接口限流 10s内只能访问两次
     * @return
     */
    @RequestMapping(value = "hello")
    @Limit(name = "测试接口限流",key = "hello",prefix = "limit",period = 10,count = 2)
    public String hello() {
        return "hello world";
    }

}
