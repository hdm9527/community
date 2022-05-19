package com.example.service;

import com.example.dto.QuestionDTO;
import com.example.entity.Question;
import com.example.entity.User;
import com.example.mapper.QuestionMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list(Integer page, Integer size) {
        //size * (page - 1)
        Integer offset = size * (page - 1);
        List<Question> list = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : list) {
            User user = userMapper.findUserById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
