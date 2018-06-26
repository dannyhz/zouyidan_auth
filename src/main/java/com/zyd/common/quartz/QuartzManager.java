package com.zyd.common.quartz;

import java.util.HashMap;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class QuartzManager implements InitializingBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuartzManager.class);
	
	private Scheduler scheduler;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		SchedulerFactory factory = new StdSchedulerFactory();  
		scheduler = factory.getScheduler();  
	}
	
	 /**
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass         任务
     * @param cron             时间设置，参考quartz说明文档
     * @Description: 添加一个定时任务
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass,
                       String cron, Map map) {
        try {
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            //可以放值
            jobDetail.getJobDataMap().putAll(map);

            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            LOGGER.error("添加一个定时任务异常", e);
            throw new RuntimeException(e);
        }
    }
    
    /**
     * @Description:启动所有定时任务
     */
    public void startJobs() {
        try {
            scheduler.start();
        } catch (Exception e) {
            LOGGER.error("启动所有定时任务异常", e);
            throw new RuntimeException(e);
        }
    }
}
