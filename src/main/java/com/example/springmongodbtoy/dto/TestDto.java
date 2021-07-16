package com.example.springmongodbtoy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private String id;
    private String name;
    private String description;
}
