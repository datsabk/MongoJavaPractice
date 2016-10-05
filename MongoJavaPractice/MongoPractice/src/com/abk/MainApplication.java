package com.abk;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.util.JSON;

public class MainApplication {
	private static MongoConnector conn = new MongoConnector();
	public static void main(String[] args) {
		insertUser();
		findAndDisplayUsers();
		
		insertProfile();				//Insert using JSON
		
		conn.client.close();
	}
	
	private static void insertUser(){
		conn.db.getCollection("Users").insertOne(new Document().append("username", "datsabk").append("password", "IRock"));
		
	}
	
	private static void insertProfile(){
		ProfileDetails profile1 = new ProfileDetails("Abhishek", "ABC Street", "Dreamland", "DreamState", "DreamCountry", 232323, "1234123412",25);
		conn.insertObject(profile1, "Profile");
		ProfileDetails profile2 = new ProfileDetails("Chandler", "KYC Street", "New York", "Michigan", "US", 232323, "1234123412",52);
		conn.insertObject(profile2, "Profile");
	}
	
	private static void findAndDisplayUsers(){
		FindIterable<Document> iter = conn.db.getCollection("Users").find(new Document().append("username", "datsabk"));
		iter.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document){
				System.out.println("Username: "+document.get("username"));
				System.out.println("Password: "+document.get("password"));
			}
		});
	}

}
