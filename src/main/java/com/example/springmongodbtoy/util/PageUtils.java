package com.example.springmongodbtoy.util;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageUtils {
    public static Pageable convertPage(int offset, int limit){
        return PageRequest.of(offset/limit, limit);
    }
}
