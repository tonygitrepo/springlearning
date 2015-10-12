package com.socialmedia.service;

import java.util.List;

import com.socialmedia.model.Timeline;

public interface TimelineService {

	Timeline save(Timeline mentionTime);
	List<Timeline> fetchTweets(String statusType);
}
