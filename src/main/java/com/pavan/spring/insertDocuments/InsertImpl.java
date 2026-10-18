package com.pavan.spring.insertDocuments;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import java.util.List;

public class InsertImpl implements Insert {

    @Override
    public void insert(MongoCollection<Document> collection, Document document) {
        InsertOneResult result = collection.insertOne(document);
        System.out.println("insert result: " + result.getInsertedId());
    }

    @Override
    public void insertMany(MongoCollection<Document> collection, List<Document> documents) {
        collection.insertMany(documents);
    }
}
