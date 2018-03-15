package com.deer.quzrtz.demo;

import com.deer.quzrtz.demo.job.FirstJob;
import com.deer.quzrtz.demo.job.Two2Job;
import com.deer.quzrtz.demo.job.TwoJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TwoTest {
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
            JobDetail job = JobBuilder.newJob(Two2Job.class).withIdentity("Two2Job", "platform")
                    .setJobData(jobDataMap)
                    .build();
            //每5秒执行一次
            String corn = "*/5 * * * * ?";
            //  corn表达式  每五秒执行一次
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity("Two2Job", "platform")
                    .withSchedule(CronScheduleBuilder.cronSchedule(corn))
                    .startNow().build();


            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);


            // 启动调度
            scheduler.start();

            JobDataMap jobDataMap2 = new JobDataMap();
            jobDataMap2.put("Key","第二个Value");
            Scheduler scheduler2=null;
            // 通过schedulerFactory获取一个调度器
            scheduler2 = schedulerfactory.getScheduler();
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job2 = JobBuilder.newJob(Two2Job.class).withIdentity("TwoJob", "platform")
                    .setJobData(jobDataMap2)
                    .build();
            //每5秒执行一次
            String corn2 = "*/5 * * * * ?";
            //  corn表达式  每五秒执行一次
            Trigger trigger2=TriggerBuilder.newTrigger().withIdentity("TwoJob", "platform")
                    .withSchedule(CronScheduleBuilder.cronSchedule(corn2))
                    .startNow().build();

            scheduler2.scheduleJob(job2, trigger2);

            Thread.sleep(10000);

            // 停止调度
            scheduler.shutdown();
            scheduler2.shutdown();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
