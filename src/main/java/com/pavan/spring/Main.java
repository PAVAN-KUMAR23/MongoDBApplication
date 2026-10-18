package com.pavan.spring;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {

        String connectionString = "mongodb+srv://myAtlasDBUser:myatlas-001@myatlasclusteredu.hpju5ui.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            mongoClient.listDatabases().forEach(db -> System.out.println(db.toString()));
        }


    }
}
