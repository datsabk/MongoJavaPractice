package com.abk;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnector {

	private static Gson gson = new Gson();
	MongoClient client =null;
	MongoDatabase db = null;
	
	MongoConnector(){
		client = new MongoClient();
		db = client.getDatabase("Practice");
	}
	
	MongoConnector(String dbName){
		client = new MongoClient();
		db = client.getDatabase(dbName);
	}
	
	public void insertObject(Object object,String collectionName){
		String json = gson.toJson(object);
		System.out.println(json);
		Document dbObject = Document.parse(json);
		db.getCollection(collectionName).insertOne(dbObject);
	}
}
