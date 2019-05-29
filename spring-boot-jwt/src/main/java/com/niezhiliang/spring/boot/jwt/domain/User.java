package com.niezhiliang.spring.boot.jwt.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 上午11:31
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Integer id;

    private String account;

    private String password;

    private Date createAt;
}
