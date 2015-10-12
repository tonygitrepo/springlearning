package com.socialmedia.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import twitter4j.Status;

import com.socialmedia.model.SocialMediaHub;
import com.socialmedia.model.Timeline;
import com.socialmedia.service.SocialMediaHubService;
import com.socialmedia.service.TimelineService;
import com.socialmedia.utility.PostToTwitter;
import com.socialmedia.utility.ReadFromTwitter;

@Controller
//@SessionAttributes("surveyPost")
public class SocialMediaHubController {
	
	@Autowired
	private SocialMediaHub socialMediaHub;
	
	@Autowired	
	private PostToTwitter postTwt;
	
	@Autowired
	private SocialMediaHubService socialMediaHubService;
	
	@Autowired
	private ReadFromTwitter readFromTwitter;
	
	@Autowired
	private TimelineService timelineService;
	
	
//	  @RequestMapping(value="/postsurvey", method=RequestMethod.POST)
//	  public String postSurvey(@Valid @ModelAttribute("surveypost") SurveyPost surveypost, BindingResult result, Model model) {        
//	      if(result.hasErrors()) {
//	          return "postsurvey";
//	      } 
////	          else if(surveyPostService.findByProdId(prodId)(student.getUserName())) {
////	          model.addAttribute("message", "User Name exists. Try another user name");
////	          return "signup";
//	      else {
//	    	  surveyPostService.save(surveypost);
//	          model.addAttribute("message", "Saved student details");
//	          return "redirect:success.html";
//	      }
//	  }

//	  @RequestMapping(value="/success", method=RequestMethod.GET)
//		public String getSuccessPage(Model model) {			
//			//SocialMediaHub smHub = new SocialMediaHub();		
//			//model.addAttribute("smHub", socialMediaHub);
//			//programModelList(model);
//			return "success";
//		}
	  
	  @RequestMapping(value="/socialmedia", method=RequestMethod.GET)
		public String getPostPage(Model model) {			
			//SocialMediaHub smHub = new SocialMediaHub();		
			model.addAttribute("smHub", socialMediaHub);
			programModelList(model);
			return "socialmedia";
		}
		
		@RequestMapping(value="/socialmedia", method=RequestMethod.POST)
		public String postFeed(@Valid @ModelAttribute("smHub") SocialMediaHub smHub, BindingResult result,Model model) {
			if (result.hasErrors()) {
				programModelList(model);				
				return "socialmedia";
			} else {				
				try{
					postTwt.doPostTweet(smHub.getSocialFeed());
				}catch(Exception e){
					e.printStackTrace();
				}
				socialMediaHubService.save(smHub);
				boolean found = socialMediaHubService.findBySocialFeedId(smHub.getSocialFeedId());
				if (found) {				
					return "success";
				} else {				
					return "failure";
				}
			}
			
		}
	  
		private void programModelList(Model model) {			
			        Map<String,String> programList = new HashMap<String, String>(); 		
			        programList.put("BRAVSRV001","Bravia Android TV Survey");			
			        programList.put("CHRSTCAMP001","Xperia Christmas Campaign");			
			        model.addAttribute("programList", programList);			
			    }

	  @RequestMapping(value="/fetchtweets/{pid}", method=RequestMethod.GET)
		public String getFetchPage(Model model,@PathVariable String pid) {			
			//SocialMediaHub smHub = new SocialMediaHub();		
			//model.addAttribute("smHub", socialMediaHub);
			//programModelList(model);
		  if("service".equalsIgnoreCase(pid))
			return "service";
		  else
			  return "analytics";
		}
	  
	  
	  @RequestMapping(value="/fetchtweets/{pid}", method=RequestMethod.POST)
		public String postFeed(@Valid @ModelAttribute("readFromTwitter") @RequestParam(value="param1") String param1, Timeline timeline, BindingResult result,Model model,@PathVariable String pid) {
//			if (result.hasErrors()) {		
//				return "fetchtweets";
//			} else {
				try{
					List<Status> statuses=readFromTwitter.getTimeline(param1);
					for(Status status: statuses)
					{
						timeline.setStatusId(status.getId());
						timeline.setStatusCreatedAt(status.getCreatedAt());
						timeline.setStatusFavCount(status.getFavoriteCount());
						List list = Arrays.asList(status.getHashtagEntities());
						//mentionsTimeline.setMentionTimeStatusHashTag(list);
						timeline.setStatusLang(status.getLang());
						timeline.setStatusText(status.getText().replace("@tonyisaac82",""));
						timeline.setStatusUser(status.getUser().getName());
						timeline.setStatusReplyCount(status.getRetweetCount());						
						timeline.setStatusType(param1);
						timelineService.save(timeline);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}				
				List<Timeline> statusList=timelineService.fetchTweets(param1);
				model.addAttribute("statusList", statusList);
				model.addAttribute("statusType", param1);
				 if("service".equalsIgnoreCase(pid))
						return "service";
					  else
						  return "analytics";
				
			//}
			
		}
	  
}
