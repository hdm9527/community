package com.example.mapper;

import com.example.model.Question;

public interface QuestionExtMapper {
    int incView(Question question);
    int incCommentCount(Question question);
}
