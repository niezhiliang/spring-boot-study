package com.niezhiliang.spring.boot.jwt.exception;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 下午3:49
 */
@Data
public class TokenException extends RuntimeException {

    private String response;

    public TokenException() {
        super();
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(int code,String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        this.response = JSON.toJSONString(jsonObject);
    }
}
