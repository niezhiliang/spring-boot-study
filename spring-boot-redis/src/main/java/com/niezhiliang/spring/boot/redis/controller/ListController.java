package com.niezhiliang.spring.boot.redis.controller;

import com.niezhiliang.spring.boot.redis.utils.RedisListTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private RedisListTools redisListTools;

    @RequestMapping(value = "saveOne")
    public String saveOne() {
        redisListTools.leftPush("hello",1);
        return "success";
    }

    @RequestMapping(value = "saveList")
    public String saveList() {
        redisListTools.leftPushList("hello", Arrays.asList(5,6,7,4,3,9));
        return "success";
    }

    @RequestMapping(value = "getList")
    public Object getByList() {
        return  redisListTools.rightPop("hello");
    }

    @RequestMapping(value = "getAll")
    public Object getAll() {
        return redisListTools.getAll("hello");
    }
}
