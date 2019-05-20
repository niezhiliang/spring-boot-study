package com.niezhiliang.spring.boot.current.limite.exception;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/20 上午10:18
 */
public class LimitAccessException extends Exception{

    private static final long serialVersionUID = -3608667856397125671L;

    public LimitAccessException(String message) {
        super(message);
    }
}
