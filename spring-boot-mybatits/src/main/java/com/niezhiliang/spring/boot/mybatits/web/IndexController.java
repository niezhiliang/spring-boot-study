package com.niezhiliang.spring.boot.mybatits.web;

import com.niezhiliang.spring.boot.mybatits.domain.User;
import com.niezhiliang.spring.boot.mybatits.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/22 下午3:41
 */
@RestController
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "add")
    public User addUser() {

        User user = new User();
        user.setName("苏雨");
        user.setSex("男");
        user.setAge(20);
        user.setAddress("杭州市江干区");

        userMapper.insertSelective(user);

        return user;
    }

    @RequestMapping(value = "query")
    public User query() {
        return userMapper.selectByPrimaryKey(1);
    }

}
