package com.niezhiliang.spring.boot.current.limite.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/20 上午9:45
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {

    String name() default "";

    /**
     * redis key
     * @return
     */
    String key() default "";

    /**
     * redis  key 前缀
     * @return
     */
    String prefix() default "";

    /**
     * 时间，秒
     * @return
     */
    int period();

    /**
     * 次数
     * @return
     */
    int count();

}
