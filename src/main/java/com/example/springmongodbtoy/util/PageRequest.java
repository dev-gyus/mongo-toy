package com.example.springmongodbtoy.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageRequest {

    private int offset;

    private int limit;

}