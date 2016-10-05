package com.abk;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.util.JSON;
import static com.mongodb.client.model.Filters.*;

import java.util.regex.Pattern;
public class MainApplication {
	private static MongoConnector conn = new MongoConnector();
	public static void main(String[] args) {
		//insertUser();
		//findAndDisplayUsers();
		
		//insertProfile();				//Insert using JSON
		findAndDisplayProfiles();
		conn.client.close();
	}
	
	private static void insertUser(){
		conn.db.getCollection("Users").insertOne(new Document().append("username", "datsabk").append("password", "IRock"));
		
	}
	
	private static void insertProfile(){
		for(int i =0; i<10000;i++){
		ProfileDetails profile = new ProfileDetails("Abhishek"+i, "ABC Street", "Dreamland", "DreamState", "DreamCountry", 232323, "1234123412",25);
		conn.insertObject(profile, "Profile");
		}
		
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
	
	private static void findAndDisplayProfiles(){
		//Regex based search
		FindIterable<Document> iter = conn.db.getCollection("Profile").find(regex("name",Pattern.compile("^(?i)"+Pattern.quote("abhishek999"))));
		iter.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document){
				System.out.println("Name: "+document.get("name"));
				System.out.println("Mobile No: "+document.get("mobileNo"));
				System.out.println("Age: "+document.get("age"));
				System.out.println("Address: "+((Document)document.get("address")).get("street")+", "+((Document)document.get("address")).get("City")+", "+((Document)document.get("address")).get("State")+", "+((Document)document.get("address")).get("Country")+", "+((Document)document.get("address")).get("pincode"));
				
			}
		});
	}

}
