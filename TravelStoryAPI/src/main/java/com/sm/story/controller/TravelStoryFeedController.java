package com.sm.story.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.story.feed.dto.TravelStoryFeedDTO;
import com.sm.story.feed.service.TravelStoryFeedService;

/**
 * 
 * @author SamarjeetYadav
 *@RestController : API related to Travel story feed: CRUD Operation
 */

@RestController
public class TravelStoryFeedController {
	@Autowired
	TravelStoryFeedService travelStoryFeedService;
	
	@RequestMapping("/feeds")
	public List<TravelStoryFeedDTO> listTravelStoryFeeds(TravelStoryFeedDTO travelStoryFeedDTO)
	{
		List<TravelStoryFeedDTO> feedList=null;
		try
		{
		 feedList=travelStoryFeedService.listTravelStoryFeed(travelStoryFeedDTO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return feedList;
	}

}
