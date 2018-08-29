package com.sm.story.feed.db;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sm.story.feed.dto.TravelStoryFeedDTO;

@Repository
public class TravelStoryFeedDBImpl implements TravelStoryFeedDB {
	
	public TravelStoryFeedDBImpl()
	{
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
	}
	
   // static MongoClientURI uri  = new MongoClientURI("mongodb://samarjeet:asdzxc123@ds239097.mlab.com:39097"); 
	static MongoClientURI uri  = new MongoClientURI("mongodb://samarjeet:samarjeet123@ds133762.mlab.com:33762/storyfeed"); 
    
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase database = client.getDatabase(uri.getDatabase());
	public void addTravelStoryFeed(TravelStoryFeedDTO travelStoryFeedDTO) throws Exception
	 {
		 MongoCollection<Document> collection = database.getCollection("travelStoryfeed");
		 Document document = new Document("feedBody", travelStoryFeedDTO.getFeedBody())
	               .append("feedType", travelStoryFeedDTO.getFeedType())
	               .append("editFlag", "Y");
		 
		collection.insertOne(document);
		//database.
		 

	 }
	
	
	

	@Override
	 public List<TravelStoryFeedDTO> listTravelStoryFeed(TravelStoryFeedDTO travelStoryFeedDTO) throws Exception
	 {
		 List<TravelStoryFeedDTO> feedList=new ArrayList<>();
		 TravelStoryFeedDTO feed=null;
		 MongoCollection<Document> collection = database.getCollection("travelStoryfeed");
		 FindIterable<Document> curList=null;
		/* if(null!=questionAnswerDTO.get_id() && ! "".equals(questionAnswerDTO.get_id()))
		 {
			 
			 curList = collection.find( eq("_id", new ObjectId(questionAnswerDTO.get_id())));
			 
		 }
		 else
		 {
			 curList = collection.find();
		 }*/
		 
		 curList = collection.find();
		 for ( Document cur : curList) {
			 feed=new TravelStoryFeedDTO();
			 feed.setFeedid(cur.getObjectId("_id").toString());
			 feed.setFeedBody(cur.get("feedBody")+"");
			 feed.setFeedType(cur.get("feedType")+"");
			 feed.setEditFlag(cur.get("editFlag")+"");
			 feedList.add(feed);
			}
		 
	feedList.forEach(x-> {System.out.println(x.getFeedBody());
							System.out.println(x.getFeedType());});
		 
		 return feedList;
	 }
	 
	 /* 
	 public List<QuestionAnswerDTO> listCollections(QuestionAnswerDTO questionAnswerDTO) throws Exception
	 {
		 List<QuestionAnswerDTO> questionAnswerList=new ArrayList<>();
		 QuestionAnswerDTO questionAnswerOutDTO=null;
		 
		 MongoIterable<String> colls = database.listCollectionNames();
		 //database.

		 for (String s : colls) {
			 questionAnswerOutDTO=new QuestionAnswerDTO();
			 questionAnswerOutDTO.setCollectionName(s);
			 questionAnswerList.add(questionAnswerOutDTO);
		 }
		
		 
		System.out.println(questionAnswerList);
		 
		 return questionAnswerList;
	 }

	 
		public void addTechHelpingItem(TechnologyHelpingItem techHelpingItem) throws Exception
		 {
			 MongoCollection<Document> collection = database.getCollection("TechnologyHelpingItem");
			 Document document = new Document("itemName", techHelpingItem.getItemName())
		               .append("itemDisplayName", techHelpingItem.getItemDispayName());
			 
			 
			collection.insertOne(document);
			//database.
			 

		 }
		
		
		 public List<TechnologyHelpingItem> listTechHelpingItem(TechnologyHelpingItem techHelpingItem) throws Exception
		 {
			 List<TechnologyHelpingItem> techitemList=new ArrayList<>();
			 TechnologyHelpingItem techItem=null;
			 String CollectionName="TechnologyHelpingItem";
			 MongoCollection<Document> collection = database.getCollection(CollectionName);
			 FindIterable<Document> curList=null;
		 
				 curList = collection.find( );
				 
			
			 for ( Document cur : curList) {
				 techItem=new TechnologyHelpingItem();
				 techItem.set_id(cur.getObjectId("_id").toString());
				 techItem.setItemDispayName(cur.get("itemDisplayName")+"");
				 techItem.setItemName(cur.get("itemName")+"");
				 techitemList.add(techItem);
				}
			 
			System.out.println(techitemList);
			 
			 return techitemList;
		 }
		
		public void addTechHelpingItemContent(TechnologyHelpingItemContent techItemContent) throws Exception
		 {
			 String CollectionName="TechnologyHelpingItemContent";
			 MongoCollection<Document> collection = database.getCollection(CollectionName);
			 Document document = new Document("contentType", techItemContent.getType())
		               .append("content", techItemContent.getContent())
		               .append("itemId", techItemContent.getItem_id());
			 
			collection.insertOne(document);
			//database.
			 

		 }
		
		 public List<TechnologyHelpingItemContent> listTechHelpingItemContent(TechnologyHelpingItemContent techHelpingItemContent) throws Exception
		 {
			 List<TechnologyHelpingItemContent> techContentList=new ArrayList<>();
			 TechnologyHelpingItemContent techContent=null;
			 String CollectionName="TechnologyHelpingItemContent";
			 MongoCollection<Document> collection = database.getCollection(CollectionName);
			 FindIterable<Document> curList=null;
		 
				 curList = collection.find( eq("itemId", techHelpingItemContent.getItem_id()));
				 
			
			 for ( Document cur : curList) {
				 techContent=new TechnologyHelpingItemContent();
				 techContent.set_id(cur.getObjectId("_id").toString());
				 techContent.setContent(cur.get("content")+"");
				 techContent.setType(cur.get("contentType")+"");
				 techContentList.add(techContent);
				}
			 
			System.out.println(techContentList);
			 
			 return techContentList;
		 }
	*/ 
	 public static void main(String[] args) throws Exception{
	        
		 TravelStoryFeedDBImpl travelStoryFeedDBImpl=new TravelStoryFeedDBImpl();
		 TravelStoryFeedDTO travelStoryFeedDTO=new TravelStoryFeedDTO();
		 
		 travelStoryFeedDTO.setFeedBody("This is story conetent and story is baed on journey and it sample to perform testing");
		 travelStoryFeedDTO.setFeedType("Travel");
		 System.out.println("Started");
		 travelStoryFeedDBImpl.addTravelStoryFeed(travelStoryFeedDTO);
		 travelStoryFeedDBImpl.listTravelStoryFeed(travelStoryFeedDTO);
		 System.out.println("****************Completed**************");
	        
	        
	 }
	        
	
	
}

