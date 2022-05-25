package com.example.mapper;

import com.example.model.Question;

public interface QuestionExtMapper {
    void incView(Question question);
    void incCommentCount(Question question);
}
