package com.sm.story.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.story.feed.db.TravelStoryFeedDB;
import com.sm.story.feed.dto.TravelStoryFeedDTO;

@Service
public class TravelStoryFeedServiceImpl implements TravelStoryFeedService {
	
	@Autowired
	TravelStoryFeedDB travelStoryFeedDB;
	
	@Override
	public List<TravelStoryFeedDTO> listTravelStoryFeed(TravelStoryFeedDTO travelStoryFeedDTO) throws Exception
	{
		List<TravelStoryFeedDTO> feedList=null;
		try
		{
		 feedList=travelStoryFeedDB.listTravelStoryFeed(travelStoryFeedDTO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return feedList;
	}

}
