package com.kaysush.sentisuggest;

import com.kaysush.sentisuggest.twitter.FetchJobScheduler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.SchedulerException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        try {
            FetchJobScheduler.start("sushilramuk");
        } catch (SchedulerException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
