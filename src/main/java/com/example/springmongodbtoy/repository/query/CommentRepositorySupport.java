package com.example.springmongodbtoy.repository.query;

import com.example.springmongodbtoy.dao.CommentDao;
import com.example.springmongodbtoy.dao.MoviesDao;

import com.example.springmongodbtoy.dao.QCommentDao;
import com.example.springmongodbtoy.dao.QMoviesDao;
import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.repository.CommentCrudRepository;
import com.example.springmongodbtoy.repository.MoviesCrudRepository;
import com.querydsl.core.QueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.querydsl.binding.QuerydslBindingsFactory;
import org.springframework.stereotype.Repository;

import java.security.InvalidParameterException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CommentRepositorySupport {
    private final CommentCrudRepository commentCrudRepository;
    private final MoviesCrudRepository moviesCrudRepository;
    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;

    public List<CommentDto> findAllByName(String name) {
        LocalDateTime startTime = LocalDateTime.now();
        log.info("Start Logic, start time at {}", startTime);
        List<CommentDto> dtoList = new ArrayList<>();

        Criteria nameCriteria = new Criteria("");

        AggregationResults<CommentDto> aggregate = mongoTemplate.aggregate(Aggregation.newAggregation(
                Aggregation.match(nameCriteria),
                Aggregation.project("id", "name", "email"),
                Aggregation.limit(10L)
        ), CommentDao.class, CommentDto.class);
        List<CommentDto> comments = aggregate.getMappedResults();
        log.info("Convert aggregation result to json = {}", aggregate.getRawResults().toJson());

//        Query query = new Query(nameCriteria);
//        List<CommentDao> commentDaos = mongoTemplate.find(query, CommentDao.class);
        LocalDateTime queryEndTime = LocalDateTime.now();
        log.info("completed send query, now time is {}, during time {}", queryEndTime, Duration.between(startTime, queryEndTime).getSeconds());


//        List<CommentDto> comments = commentDaos.stream().map(dao -> modelMapper.map(dao, CommentDto.class)).collect(Collectors.toList());



        LocalDateTime endTime = LocalDateTime.now();
        log.info("End Logic, end time at {}, during time {}", endTime, Duration.between(startTime, endTime).getSeconds());
        return comments;
    }

    public List<CommentDto> findAllCommentsByQueryDsl(String title){
        int page = 0;
        LocalDateTime startTime = LocalDateTime.now();
        log.info("Start Logic, start time at {}", startTime);

        MoviesDao moviesDao = moviesCrudRepository.findOne(
                QMoviesDao.moviesDao.title.eq(title)
        ).orElseThrow(() -> new InvalidParameterException());

        Iterable<CommentDao> comments = commentCrudRepository.findAll(
                QCommentDao.commentDao.movie_id.eq(moviesDao.getId())
        );

        List<CommentDto> dtoList = new ArrayList<>();
        comments.forEach(dao -> {
            CommentDto dto = modelMapper.map(dao, CommentDto.class);
            dto.setId(dao.getId().toString());
            dtoList.add(dto);
        });

        LocalDateTime endTime = LocalDateTime.now();
        log.info("End Logic, end time at {}, during time {}", endTime, Duration.between(startTime, endTime).getSeconds());
        return dtoList;
    }

    public List<CommentDto> findAllCommentsByMongoTemplate(String title){
        LocalDateTime startTime = LocalDateTime.now();
        log.info("Start Logic, start time at {}", startTime);

        Criteria titleCriteria = new Criteria("title").is(title);
        Query titleQuery = new Query(titleCriteria);
        MoviesDao moviesDao = mongoTemplate.findOne(titleQuery, MoviesDao.class);

//        MoviesDao moviesDao = moviesCrudRepository.findOne(
//                QMoviesDao.moviesDao.title.eq(title)
//        ).orElseThrow(() -> new InvalidParameterException());

        Criteria movie_id = new Criteria("movie_id").is(moviesDao.getId());
        Query query = new Query(movie_id);
        List<CommentDao> commentDaos = mongoTemplate.find(query, CommentDao.class);
        List<CommentDto> dtoList = commentDaos.stream().map(dao -> {
            CommentDto dto = modelMapper.map(dao, CommentDto.class);
            dto.setId(dao.getId().toString());
            return dto;
        }).collect(Collectors.toList());

        LocalDateTime endTime = LocalDateTime.now();
        log.info("End Logic, end time at {}, during time {}", endTime, Duration.between(startTime, endTime).getSeconds());
        return dtoList;
    }
}
