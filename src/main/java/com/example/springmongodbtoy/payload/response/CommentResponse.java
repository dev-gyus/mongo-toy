package com.example.springmongodbtoy.payload.response;

import com.example.springmongodbtoy.dao.CommentDao;
import com.example.springmongodbtoy.payload.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private List<Comment> commentDaoList;
}
