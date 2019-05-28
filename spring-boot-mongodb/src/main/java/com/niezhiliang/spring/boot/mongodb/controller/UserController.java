package com.niezhiliang.spring.boot.mongodb.controller;

import com.niezhiliang.spring.boot.mongodb.domain.Page;
import com.niezhiliang.spring.boot.mongodb.domain.User;
import com.niezhiliang.spring.boot.mongodb.repository.UserRepository;
import com.niezhiliang.spring.boot.mongodb.utils.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 上午9:49
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "save")
    public Object saveUser(User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    /**
     * 查询User中所有的数据
     * 支持分页
     * @param page
     * @return
     */
    @RequestMapping(value = "/getall")
    public Object getAll(Page page) {
        try {
            Pageable pageable = new PageRequest(page.getPageNo(),page.getPageSize());//第一页为0
            return userRepository.findAll(pageable).getContent();
        } catch (Exception e) {
            return userRepository.findAll();
        }
    }

    /**
     * 通过userid查询某个user
     * @param userid
     * @return
     */
    @RequestMapping(value = "getone")
    public Object getOne(String userid) {
        return userRepository.findById(userid);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "update")
    public Object updateUser(User user) {
        User old = userRepository.findById(user.getId()).get();
        try {
            //因为Repository 并没有提供修改的方法 我们就用其save方法 如果userid不为空，就会对数据进行修改
            //如果你只修改其中两个字段，save方法就会把其余的属性变为null 为了解决这个问题 先将该数据查出来，
            // 再通过反射将未赋值的属性赋上原来的值
            user = (User) UpdateUtil.fillObject(old,user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userRepository.save(user);
        return userRepository.findAll();
    }

    /**
     * 通过id删除
     * @param userid
     * @return
     */
    @RequestMapping(value = "delete")
    public Object deleteOne(String userid) {
        userRepository.deleteById(userid);
        return userRepository.findAll();
    }

    /**
     * 查询某性别全部用户信息
     * @param sex
     * @return
     */
    @RequestMapping(value = "getbysex")
    public Object getAllBySex(String sex) {
        return userRepository.findAllBySex(sex);
    }
}
