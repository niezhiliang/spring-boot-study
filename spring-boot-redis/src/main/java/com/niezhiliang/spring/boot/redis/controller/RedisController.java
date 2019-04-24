package com.niezhiliang.spring.boot.redis.controller;

import com.niezhiliang.spring.boot.redis.utils.RedisTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/24 下午7:18
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTools redisTools;

    /**
     * 保存
     * @param value
     * @return
     */
    @RequestMapping(value = "add")
    public String set(String value) {
        redisTools.save("hello",value,1);
        return "success";
    }

    /**
     * 获取值
     * @param value
     * @return
     */
    @RequestMapping(value = "get")
    public String get(String value) {
        System.out.println(redisTools.get(value) == null ? null : redisTools.get(value));
        System.out.println(redisTools.get(value) == "" ? "kong" : redisTools.get(value));
        return redisTools.get(value);
    }

    @RequestMapping(value = "delete")
    public Object delete(String key) {
        return redisTools.delete(key);
    }

    @RequestMapping(value = "haskey")
    public Object haskey(String key) {
        return redisTools.hasKey(key);
    }
}
