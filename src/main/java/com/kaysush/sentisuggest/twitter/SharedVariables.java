/**
 * This class keeps the shared variables like
 * current tweet and current sentiment status
 */

package com.kaysush.sentisuggest.twitter;

/**
 *
 * @author SUSHIL
 */
public class SharedVariables {
    
    private static String currentTweet;

    public static String getCurrentTweet() {
        return currentTweet;
    }

    public static void setCurrentTweet(String currentTweet) {
        SharedVariables.currentTweet = currentTweet;
    }

    private static String currentSentiment;

    public static String getCurrentSentiment() {
        return currentSentiment;
    }

    public static void setCurrentSentiment(String currentSentiment) {
        SharedVariables.currentSentiment = currentSentiment;
    }

}
