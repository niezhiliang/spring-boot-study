package com.niezhiliang.spring.boot.mybatits.plus.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/3/16 上午9:50
 */
@Data
public class Student extends Model<Student> {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "userName")
    private String userName;

    private Integer age;

    private Byte sex;

    private String address;
}
