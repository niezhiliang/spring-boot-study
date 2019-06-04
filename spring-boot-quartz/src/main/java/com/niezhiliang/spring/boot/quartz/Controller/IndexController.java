package com.niezhiliang.spring.boot.quartz.Controller;

import com.niezhiliang.spring.boot.quartz.job.JobDemo;
import com.niezhiliang.spring.boot.quartz.service.QuartzService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class IndexController {


    @Autowired
    private QuartzService quartzService;

    @RequestMapping(value = "/")
    public String add() throws Exception {
        quartzService.addJob(JobDemo.class,"hello","hello","hello world1",new Date(System.currentTimeMillis() + 10000));
        return "success";
    }

    @RequestMapping(value = "stop")
    public String stop() throws SchedulerException{
        quartzService.stopJob("hello","hello");
        return "success";
    }

    @RequestMapping(value = "resume")
    public String resumeJob() throws SchedulerException {
        quartzService.resumeJob("hello","hello");
        return "success";
    }

    @RequestMapping(value = "delete")
    public String delete() throws SchedulerException  {
        quartzService.deleteJob("hello","hello");
        return "success";
    }
}
