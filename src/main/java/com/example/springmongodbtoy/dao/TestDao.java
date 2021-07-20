package com.example.springmongodbtoy.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Getter @Setter
@Document("test_collection")
@NoArgsConstructor
@AllArgsConstructor
public class TestDao {
    @Id
    private ObjectId id;
    private String name;
    private List<String> testList;
}
