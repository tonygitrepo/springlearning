package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.model.Timeline;
import com.socialmedia.repository.TimelineRepository;


@Service("timelineService")
public class TimelineServiceImpl implements TimelineService {

	@Autowired
	private TimelineRepository timelineRepository;	
	
	public Timeline save(Timeline mentionTime) {
		// TODO Auto-generated method stub
		return timelineRepository.saveAndFlush(mentionTime);
	}
	
	public List<Timeline> fetchTweets(String statusType)
	{
		//return timelineRepository.findAll();
		return timelineRepository.findByStatusType(statusType);
	}

}
