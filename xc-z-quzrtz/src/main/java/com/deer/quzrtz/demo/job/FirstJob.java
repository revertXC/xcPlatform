package com.deer.quzrtz.demo.job;

import org.quartz.*;

/**
 * quzrtz 定义一个JOB任务
 * 默认并发执行
 */
//@DisallowConcurrentExecution  //不并发执行
public class FirstJob implements Job {
    /**
     * 执行
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        jobExecutionContext.get
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        jobDetail.getKey();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        System.out.println("Quzrtz 定时器执行！！！");
    }
}
