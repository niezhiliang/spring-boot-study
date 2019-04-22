package com.niezhiliang.spring.boot.global.exception.exception;

import com.niezhiliang.spring.boot.global.exception.entity.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/22 下午7:39
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有的系统异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> SystemErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(100);
        errorInfo.setData("this is some data");
        errorInfo.setUrl(req.getRequestURL().toString());
        errorInfo.setMsg(e.getMessage());
        return errorInfo;
    }

    /**
     * 处理所有的业务逻辑异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ErrorInfo<String> BusinessErrorHandler(HttpServletRequest req, BusinessException e) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(101);
        errorInfo.setData("this is some data");
        errorInfo.setUrl(req.getRequestURL().toString());
        errorInfo.setMsg(e.getMessage());
        return errorInfo;
    }

}