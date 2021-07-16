package com.example.springmongodbtoy.dao;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Auditing {
    @CreatedDate
    private LocalDateTime createdDt;
    @LastModifiedDate
    private LocalDateTime updateDt;
}
