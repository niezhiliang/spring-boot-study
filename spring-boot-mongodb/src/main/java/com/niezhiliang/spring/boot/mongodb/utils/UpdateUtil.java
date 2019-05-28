package com.niezhiliang.spring.boot.mongodb.utils;

import java.lang.reflect.Field;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 上午9:51
 */
public class UpdateUtil {

    public static Object  fillObject(Object oldobj,Object newobj) throws Exception {

        Class clazz =  newobj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if (fields[i].get(newobj) == null) {
                Object obj = fields[i].get(oldobj);
                fields[i].set(newobj,obj);
            }
        }
        return newobj;
    }
}
