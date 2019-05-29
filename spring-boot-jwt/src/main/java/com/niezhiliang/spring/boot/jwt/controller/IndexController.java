package com.niezhiliang.spring.boot.jwt.controller;

import com.niezhiliang.spring.boot.jwt.domain.User;
import com.niezhiliang.spring.boot.jwt.repository.UserRepository;
import com.niezhiliang.spring.boot.jwt.utils.JWTUtils;
import com.niezhiliang.spring.boot.jwt.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 上午11:23
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/say/hello")
    public String hello() {
        return "hello jwt";
    }

    @RequestMapping(value = "login")
    public String login() {
        User user = userRepository.findUserByAccount("admin");
        return ResultUtils.successJson(JWTUtils.generalToken(user.getAccount(),user.getPassword()));
    }


    @RequestMapping(value = "/info")
    public String get() {
        return userRepository.getOne(1).toString();
    }
}
