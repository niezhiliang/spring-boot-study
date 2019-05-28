package com.niezhiliang.spring.boot.mongodb.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 上午9:44
 */
@Data
@ToString
public class User {

    @Id
    private String id;

    private String userName;

    private String sex;

    private Integer age;
}
