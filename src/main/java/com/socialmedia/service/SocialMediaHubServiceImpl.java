package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.model.SocialMediaHub;
import com.socialmedia.repository.SocailMediaHubRepository;
import com.socialmedia.utility.SocialHubUtility.UIDGenerator;

@Service("socialMediaHubService")
public class SocialMediaHubServiceImpl implements SocialMediaHubService{

  @Autowired
  private SocailMediaHubRepository socialMediaHubRepository;	
  
  
  @Transactional
  public SocialMediaHub save(SocialMediaHub smHub) {
	  UIDGenerator uidGen=new UIDGenerator();
	  smHub.setSocialFeedId(uidGen.nextUID());
	  return socialMediaHubRepository.saveAndFlush(smHub);
  }



  public boolean findBySocialFeedId(String socialFeedId) {
	  SocialMediaHub survPost = socialMediaHubRepository.findBySocialFeedId(socialFeedId);
	 // SurveyPost survPost = surveyRepository.findOne(Long.valueOf(prodId));

      if(survPost != null) {
          return true;
      }

      return false;
  }

}