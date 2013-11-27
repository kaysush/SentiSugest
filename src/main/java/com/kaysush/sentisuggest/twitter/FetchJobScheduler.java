/**
 * This class starts the FetchJob with the help
 * of cron trigger
 */

package com.kaysush.sentisuggest.twitter;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author SUSHIL
 */
public class FetchJobScheduler {
    public static void start(String username) throws SchedulerException{
        JobDataMap map = new JobDataMap();
        map.put("username", username);
        JobDetail job = JobBuilder.newJob(FetchJob.class)
                .withIdentity("TweetFetchJob" , "group1").usingJobData(map).build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("TweetFetchJobTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
