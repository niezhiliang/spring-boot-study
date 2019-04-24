package com.niezhiliang.spring.boot.global.exception.controller;

import com.niezhiliang.spring.boot.global.exception.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/22 下午7:41
 */
@RestController
public class IndexController {

    /**
     * http://localhost:8080/business
     * @param msg
     * @return
     */
    @RequestMapping(value = "business")
    public String business(String msg) {

        if (msg == null) {
            throw new BusinessException("参数不能为空");
        }
        return "test business ecxeption";
    }


    /**
     * http://localhost:8080/system
     * @return
     */
    @RequestMapping(value = "system")
    public String system() {
        int i = 1/0;
        return "test system ecxeption";
    }
}