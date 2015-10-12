package com.socialmedia.utility;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class PostToTwitter {
	
	@Autowired
	private SocialHubUtility util;

	public void doPostTweet(String statusMessage) throws Exception {
		
	//Instantiate a re-usable and thread-safe factory
    TwitterFactory twitterFactory = new TwitterFactory();       
    //Instantiate a new Twitter instance
    Twitter twitter = twitterFactory.getInstance();
    
     StatusUpdate statusUpdate = new StatusUpdate(statusMessage+" "+"https://www.surveymonkey.com/r/SS8RQWZ");
     statusUpdate.setMedia(
                //title of media
                "https://www.surveymonkey.com/r/SS8RQWZ"
                , util.urlInputStream("http://aquaterraculinary.com/kidswebsite/wp-content/uploads/2014/10/takesurvey.jpg"));
       //tweet or update status     
       Status status = twitter.updateStatus(statusUpdate);
	}
	
}