package com.pavan.spring.insertDocuments;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public interface Insert {

    void insert(MongoCollection<Document> collection, Document document);
    void insertMany( MongoCollection<Document> collection,List<Document> documents);
}
