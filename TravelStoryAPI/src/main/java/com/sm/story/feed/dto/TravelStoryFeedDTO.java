package com.sm.story.feed.dto;

public class TravelStoryFeedDTO {
	
	private String feedid;
	private String feedBody;
	private String feedType;
	private String ureatedBy;
	private String updatedBy;
	private String editFlag;
	
	public String getFeedid() {
		return feedid;
	}
	public void setFeedid(String feedid) {
		this.feedid = feedid;
	}
	public String getFeedBody() {
		return feedBody;
	}
	public void setFeedBody(String feedBody) {
		this.feedBody = feedBody;
	}
	public String getFeedType() {
		return feedType;
	}
	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}
	public String getUreatedBy() {
		return ureatedBy;
	}
	public void setUreatedBy(String ureatedBy) {
		this.ureatedBy = ureatedBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
	

}
