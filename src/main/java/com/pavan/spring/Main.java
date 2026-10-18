package com.pavan.spring;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pavan.spring.insertDocuments.Insert;
import com.pavan.spring.insertDocuments.InsertImpl;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {

        String connectionString = "mongodb+srv://myAtlasDBUser:myatlas-001@myatlasclusteredu.hpju5ui.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
           // databases.forEach(document -> {System.out.println(document.getString("name"));});
            MongoDatabase database = mongoClient.getDatabase("sample_training");
            //List<String> collection = database.listCollectionNames().into(new ArrayList<>());
            //List<Document> collectionItems = database.listCollections().into(new ArrayList<>());
           // collection.forEach(System.out::println);
            //collectionItems.forEach(System.out::println);

            //MongoCollection to do curd operations
            MongoCollection<Document> collection = database.getCollection("sample_training");

            //inserting a document
            Insert insert = new InsertImpl();
            Document document = new Document("id", new ObjectId())
                    .append("certificate_number",123374647)
                            .append("bussiness_name","Bellandur MOBILE FOOD CART  LICENSE TA00845")
                                    .append("date", "Oct 18 2026")
                    .append("address", new Document().append("city", "RIDGEWOOD").append("zip", 11385).append("street", "MENAHAN ST").append("number", 1712));
            insert.insert(collection,document);
        }


    }
}
