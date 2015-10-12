package com.socialmedia.utility;

import java.util.List;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class ReadFromTwitter {

	public Twitter initTwitterFactory() throws Exception {
		//Instantiate a re-usable and thread-safe factory
        TwitterFactory twitterFactory = new TwitterFactory();
        //Instantiate a new Twitter instance
        Twitter twitter = twitterFactory.getInstance();
        //setup OAuth Consumer Credentials
      //  twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
        //setup OAuth Access Token
       // twitter.setOAuthAccessToken(new AccessToken(accessTokenStr, accessTokenSecretStr));
        return twitter;
	}
       
	public  List<Status> getTimeline(String statusType){ 
		
//		try {		
//	       List<Status> statuses = twitter.getMentionsTimeline();
////	       System.out.println("########## Showing Mentioned timeline.#############");
////	       for (Status status : statuses) {
////	    	     System.out.println("mentionTimeStatusUser"+status.getUser().getName());
////	    	   	 System.out.println("mentionTimeStatusText :"+status.getText());
////	    	   	 System.out.println("mentionTimeStatusId :"+status.getId());
////	    	   	 System.out.println("mentionTimeStatusFavCount :"+status.getFavoriteCount());
////	    	   	 System.out.println("mentionTimeStatusCreatedAt :"+status.getCreatedAt());
////	    	   	 HashtagEntity hashes[]=status.getHashtagEntities();
////	    	   	 for(HashtagEntity hash: hashes)
////	    	   	 System.out.println("HashTag :"+hash.getText());
//	       
//       }
//	}catch (TwitterException te) {
//        te.printStackTrace();
//        System.out.println("Failed to get timeline: " + te.getMessage());
//        System.exit(-1);
//    }
		
	List<Status> statuses=null;	
	try {	
			Twitter	twitter=initTwitterFactory();
			if("MENTIONSTIMELINE".equals(statusType)){
			statuses = twitter.getMentionsTimeline();
			}else if("USERTIMELINE".equals(statusType)){
				statuses = twitter.getUserTimeline();	
			}
		}catch (Exception te) {
	        te.printStackTrace();
	        System.out.println("Failed to get timeline: " + te.getMessage());
	        System.exit(-1);
	    }
	return statuses;
	}
	
	
	public void getUserTimeline(Twitter twitter)
	{
		try {	  
		 List<Status> statuses = twitter.getUserTimeline();
	       System.out.println("########## Showing User timeline.###########");
	       for (Status status : statuses) {
	         //  System.out.println(status.getUser().getName() + ":" +status.getText());
	    	   	 System.out.println("userTimeStatusText :"+status.getText());
	    	   	 System.out.println("userTimeStatusId :"+status.getId());
	    	   	 System.out.println("userTimeStatusFavCount :"+status.getFavoriteCount());
	    		 System.out.println("userTimeStatusRetweetStatus :"+status.getRetweetedStatus());
	    		 HashtagEntity hashes[]=status.getHashtagEntities();
	    		 for(HashtagEntity hash: hashes)
		    	   	 System.out.println("HasTag :"+hash.getText());
	       }
		}catch (TwitterException te) {
	        te.printStackTrace();
	        System.out.println("Failed to get timeline: " + te.getMessage());
	        System.exit(-1);
	    }
	}
	
	public static String escapeHTML(String s) {
	    StringBuilder out = new StringBuilder(Math.max(16, s.length()));
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
	            out.append("&#");
	            out.append((int) c);
	            out.append(';');
	        } else {
	            out.append(c);
	        }
	    }
	    return out.toString();
	}
	
}