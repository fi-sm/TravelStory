package com.sm.story.feed.service;

import java.util.List;

import com.sm.story.feed.dto.TravelStoryFeedDTO;

public interface TravelStoryFeedService {
	
	public List<TravelStoryFeedDTO> listTravelStoryFeed(TravelStoryFeedDTO travelStoryFeedDTO) throws Exception;

}
