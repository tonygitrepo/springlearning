package com.socialmedia.service;

import org.springframework.stereotype.Service;

import com.socialmedia.model.SocialMediaHub;


public interface SocialMediaHubService {
SocialMediaHub save(SocialMediaHub surveypost);
boolean findBySocialFeedId(String socialFeedId);
}