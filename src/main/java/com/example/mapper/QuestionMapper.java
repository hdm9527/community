package com.example.mapper;

import com.example.model.Question;
import com.example.model.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface QuestionMapper {
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Question row);

    int insertSelective(Question row);

    List<Question> selectByExampleWithRowbounds(QuestionExample example, RowBounds rowBounds);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Question row, @Param("example") QuestionExample example);

    int updateByExample(@Param("row") Question row, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question row);

    int updateByPrimaryKey(Question row);
}