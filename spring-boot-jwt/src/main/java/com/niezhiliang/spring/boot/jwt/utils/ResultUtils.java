package com.niezhiliang.spring.boot.jwt.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 下午3:54
 */
public class ResultUtils {


    /**
     *
     * 成功返回
     * @return
     */
    public static String successJson() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg","success");
        return jsonObject.toJSONString();
    }

    /**
     *
     * 成功返回
     * @return
     */
    public static String successJson(Object object) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("data",object);
        jsonObject.put("msg","success");
        return jsonObject.toJSONString();
    }

    /**
     * 错误返回
     * @param code
     * @param obj
     * @param msg
     * @return
     */
    public static String errorJson(int code,Object obj,String msg) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("data",obj);
        jsonObject.put("msg",msg);

        return jsonObject.toJSONString();
    }

    /**
     * 错误返回
     * @param msg
     * @return
     */
    public static String errorJson(int code ,String msg) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg",msg);

        return jsonObject.toJSONString();
    }
}
