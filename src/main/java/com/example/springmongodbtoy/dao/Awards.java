package com.example.springmongodbtoy.dao;

import lombok.Data;

@Data
public class Awards {
    private long wins;
    private long nominations;
    private String text;
}
