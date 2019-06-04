package com.niezhiliang.spring.boot.quartz.service;

import com.niezhiliang.spring.boot.quartz.domain.QuartzInfo;
import com.niezhiliang.spring.boot.quartz.repository.QuartzInfoRepository;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;


@Component
public class QuartzServiceImpl implements QuartzService {

    @Resource
    private Scheduler scheduler;

    @Autowired
    private QuartzInfoRepository quartzInfoRepository;

    @Override
    public void addJob(Class clazz,String jobName,String groupId,String data,Date startAt) throws SchedulerException {
        // 启动调度器
        scheduler.start();

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(clazz)
                .withIdentity(jobName,groupId)
                .usingJobData("data",data)
                .build();

        //创建触发器 只执行一次
        SimpleTrigger simpleTrigger =  (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity(jobName, groupId)
                .startAt(startAt)
                //打开改代码表示5秒后执行一次 共执行5次
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(5))
                .forJob(jobName, groupId)
                .build();
        scheduler.scheduleJob(jobDetail, simpleTrigger);

        //将任务放到数据库做持久化
        QuartzInfo quartzInfo = new QuartzInfo();
        quartzInfo.setClassName(clazz.getName());
        quartzInfo.setGroupId(groupId);
        quartzInfo.setJobName(jobName);
        quartzInfo.setInvokeAt(startAt);
        quartzInfo.setCreateAt(new Date());
        quartzInfo.setSendParams(data);
        quartzInfo.setJobStatus(1);
        quartzInfoRepository.save(quartzInfo);
    }

    @Override
    public void deleteJob(String jobName,String groupId) throws SchedulerException {
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, groupId));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, groupId));
        scheduler.deleteJob(JobKey.jobKey(jobName, groupId));

        //删除调度任务
        QuartzInfo quartzInfo =
                quartzInfoRepository.findQuartzInfoByJobName(jobName);
        quartzInfoRepository.delete(quartzInfo);
    }

    @Override
    public void stopJob(String jobName, String groupId) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jobName, groupId));

        //设置为暂停
        QuartzInfo quartzInfo =
                quartzInfoRepository.findQuartzInfoByJobName(jobName);
        quartzInfo.setJobStatus(3);
        quartzInfoRepository.saveAndFlush(quartzInfo);
    }

    @Override
    public void resumeJob(String jobName, String groupId) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(jobName, groupId));
        //设置为待执行
        QuartzInfo quartzInfo =
                quartzInfoRepository.findQuartzInfoByJobName(jobName);
        quartzInfo.setJobStatus(1);
        quartzInfoRepository.saveAndFlush(quartzInfo);
    }
}
