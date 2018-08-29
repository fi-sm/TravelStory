/**
 * 
 */
package com.sm.story.feed.db;

import java.util.List;

import com.sm.story.feed.dto.TravelStoryFeedDTO;

/**
 * @author SamarjeetYadav
 *
 */

public interface TravelStoryFeedDB {
	
	 public List<TravelStoryFeedDTO> listTravelStoryFeed(TravelStoryFeedDTO travelStoryFeedDTO) throws Exception;

}
