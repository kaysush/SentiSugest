/**
 * This is a Quartz Job which fetched the tweets of the user.
 */
package com.kaysush.sentisuggest.twitter;

import com.kaysush.alchemysentimentapi.Alchemy;
import com.kaysush.alchemysentimentapi.models.AlchemyResponse;
import com.kaysush.twitterest.auth.AuthenticationException;
import com.kaysush.twitterest.auth.FetchTweets;
import com.kaysush.twitterest.auth.TwitterAuthenticator;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author SUSHIL
 */
public class FetchJob implements Job {

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        try {
            String accessToken = TwitterAuthenticator.getInstance().authenticate();

            JobDataMap map = jec.getJobDetail().getJobDataMap();
            String username = map.getString("username");
            String tweet = FetchTweets.fetch(accessToken, username).get(0).getText();
            AlchemyResponse response = Alchemy.getInstance().analyze(tweet);
            String sentiment = response.getDocSentiment().getType();
            SharedVariables.setCurrentTweet(tweet);
            SharedVariables.setCurrentSentiment(sentiment);
            System.out.println(tweet + " => " + sentiment);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FetchJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AuthenticationException ex) {
            Logger.getLogger(FetchJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnirestException ex) {
            Logger.getLogger(FetchJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
