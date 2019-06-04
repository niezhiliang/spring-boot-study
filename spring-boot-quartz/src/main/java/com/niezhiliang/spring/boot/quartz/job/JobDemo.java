package com.niezhiliang.spring.boot.quartz.job;

import com.niezhiliang.spring.boot.quartz.domain.QuartzInfo;
import com.niezhiliang.spring.boot.quartz.repository.QuartzInfoRepository;
import com.niezhiliang.spring.boot.quartz.utils.SpringContextUtil;
import lombok.Data;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Data
public class JobDemo extends QuartzJobBean implements Job {

    private String data;

//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println(this.data+ System.currentTimeMillis());
//    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hellow"+this.data+ System.currentTimeMillis());

        //TODO 如果执行完毕将数据库中任务修改为执行成功
        System.out.println("任务执行完成");

        QuartzInfoRepository quartzInfoRepository =
            SpringContextUtil.getBean(QuartzInfoRepository.class);

        QuartzInfo quartzInfo = quartzInfoRepository.findQuartzInfoByJobName(data);
        quartzInfo.setJobStatus(2);
        quartzInfoRepository.saveAndFlush(quartzInfo);
    }
}
