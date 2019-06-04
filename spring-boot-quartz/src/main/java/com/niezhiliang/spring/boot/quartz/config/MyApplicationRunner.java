package com.niezhiliang.spring.boot.quartz.config;

import com.niezhiliang.spring.boot.quartz.repository.QuartzInfoRepository;
import com.niezhiliang.spring.boot.quartz.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component//被spring容器管理
@Order(1)//如果多个自定义ApplicationRunner，用来标明执行顺序
@Slf4j
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private QuartzInfoRepository quartzInfoRepository;

    @Autowired
    private QuartzService quartzService;

    @Resource
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        log.info("开始遍历数据库中的job--------------->");
        quartzInfoRepository.findQuartzInfosByJobStatusNotIn(2)
                .forEach(quartzInfo -> {
                    Class clazz = null;
                    try {
                         clazz = Class.forName(quartzInfo.getClassName());
                         addJob(clazz,quartzInfo.getJobName(),quartzInfo.getGroupId(),quartzInfo.getSendParams(),quartzInfo.getInvokeAt());
                        //暂停的任务
                        if (quartzInfo.getJobStatus() == 3) {
                            quartzService.stopJob(quartzInfo.getJobName(),quartzInfo.getGroupId());
                        }
                    } catch (Exception e) {
                        log.error("error: {}",e.getMessage());
                    }

                });
    }

    /**
     * 添加job
     * @param clazz
     * @param jobName
     * @param groupId
     * @param data
     * @param startAt
     * @throws SchedulerException
     */
    private void addJob(Class clazz, String jobName, String groupId, String data, Date startAt) throws SchedulerException {
        // 启动调度器
        scheduler.start();

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(clazz)
                .withIdentity(jobName,groupId)
                .usingJobData("data",data)
                .build();
        //创建触发器
        SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity(jobName, groupId)
                .startAt(startAt)
                .forJob(jobName, groupId)
                .build();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
    }
}