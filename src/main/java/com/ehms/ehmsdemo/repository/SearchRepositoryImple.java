package com.ehms.ehmsdemo.repository;

import com.ehms.ehmsdemo.model.Doctor;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImple implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Doctor> searchByTest(String text) {

        final List<Doctor> doctors = new ArrayList<>();

        MongoDatabase database = client.getDatabase("ehmsdemo");
        MongoCollection<Document> collection = database.getCollection("doctor");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("lname", "fname"))))));

        result.forEach(doctor -> doctors.add(converter.read(Doctor.class, doctor)));

        return doctors;
    }

}
