package com.deer.quzrtz.demo.job;

import org.quartz.*;

@DisallowConcurrentExecution
public class Two2Job implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try{
            JobDetail jobDetail = context.getJobDetail();
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            System.out.println(jobDataMap.getKeys()[0]+" Val:"+jobDataMap.get(jobDataMap.getKeys()[0]));
            System.out.println(""+jobDetail.getKey()+"定时器睡眠");
            Thread.sleep(1000);
            System.out.println(""+jobDetail.getKey()+"睡眠完毕");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
