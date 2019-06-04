package com.niezhiliang.spring.boot.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


@Component
public class RedisListTools<T>  {

    @Resource
    private ListOperations<String,T> listOperations;

    @Resource
    private RedisTemplate<String, T> redisTemplate;

    /**
     * 移除左边第一个元素
     * @param key
     * @return
     */
    public T rightPop(String key) {
        return listOperations.rightPop(key);
    }

    /**
     * list末尾加上一个元素
     * @param key
     * @param value
     */
    public void leftPush(String key,T value) {
        listOperations.leftPush(key,value);
    }

    /**
     * list末尾加上一系列元素
     * @param key
     * @param value
     */
    public void leftPushList(String key, List<T> value) {
        listOperations.leftPushAll(key,value);
    }

    /**
     * 获取左边第一个元素并加到list末尾
     * @param key
     * @return
     */
    public T getAll (String key) {
        return listOperations.rightPopAndLeftPush(key,key);
    }

}
