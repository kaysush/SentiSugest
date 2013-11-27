/**
 * This class contains methods for preprocessing the tweets
 * before it can be analyzed for its sentiment
 */

package com.kaysush.sentisuggest.twitter;

/**
 *
 * @author SUSHIL
 */
public class Preprocessor {
    public static String preprocess(String str){
        str = str.replaceAll("@[a-zA-Z0-9]", "<USER>");
        str = str.replaceAll("https?\\:\\/\\/[_a-zA-Z0-9]+(\\/[~a-zA-Z0-9]+)*", "<URL>");
        str = str.replaceAll("&[a-zA-Z0-9]+;" , "");
        str = str.replaceAll("(.)\\1+", "$1");
        return str;
    }
}
