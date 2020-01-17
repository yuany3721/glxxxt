package com.glxxxt.site.dao;

import com.glxxxt.site.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcl
 * @since 2019-10-23
 */
public interface MessageMapper extends BaseMapper<Message> {
    int addMessage(@Param("title") String title, @Param("content") String content, @Param("date") String date);
    List<Message> getAll();
}
