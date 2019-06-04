package com.niezhiliang.spring.boot.quartz.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "quartz_info")
public class QuartzInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 任务分组
     */
    private String groupId;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务的类地址
     */
    private String className;

    /**
     * 任务需要传递的参数
     */
    private String sendParams;

    /**
     * 任务的状态 任务状态：1.待执行 2.执行成功 3.暂停
     */
    private Integer jobStatus;

    /**
     * 任务的执行时间
     */
    private Date invokeAt;

    /**
     * 任务的创建时间
     */
    private Date createAt;
}
