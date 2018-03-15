package com.deer.quzrtz.demo;

import com.deer.quzrtz.demo.job.FirstJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Test {

    public static void main(String[] args) {
        //通过schedulerFactory获取一个调度器   
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler=null;
        try{
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("Key","第一个Value");
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(FirstJob.class).withIdentity("FirstJob", "platform")
                    .setJobData(jobDataMap)
                    .build();
            //每5秒执行一次
            String corn = "*/5 * * * * ?";
            //  corn表达式  每五秒执行一次
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity("FirstJob", "platform")
                    .withSchedule(CronScheduleBuilder.cronSchedule(corn))
                    .startNow().build();

            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);

            // 启动调度
            scheduler.start();

            Thread.sleep(10000);

            // 停止调度
            scheduler.shutdown();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
