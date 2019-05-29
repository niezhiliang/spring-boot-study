package com.niezhiliang.spring.boot.jwt.hander;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.spring.boot.jwt.exception.TokenException;
import com.niezhiliang.spring.boot.jwt.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 下午3:49
 * 统一异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理所有的系统异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public String SystemErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        return ResultUtils.errorJson(400,e.getMessage());
    }

    /**
     * 处理Token异常信息
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = TokenException.class)
    public String TokenExceptionHandler(TokenException e) throws Exception {
        log.error("error:【{}】",e.getMessage());
        return e.getResponse();
    }
}
