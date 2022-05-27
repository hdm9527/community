package com.example.mapper;

import com.example.model.Notification;
import com.example.model.NotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NotificationMapper {
    long countByExample(NotificationExample example);

    int deleteByExample(NotificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Notification row);

    int insertSelective(Notification row);

    List<Notification> selectByExampleWithRowbounds(NotificationExample example, RowBounds rowBounds);

    List<Notification> selectByExample(NotificationExample example);

    Notification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Notification row, @Param("example") NotificationExample example);

    int updateByExample(@Param("row") Notification row, @Param("example") NotificationExample example);

    int updateByPrimaryKeySelective(Notification row);

    int updateByPrimaryKey(Notification row);
}