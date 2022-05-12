package top.yuany3721.glxxxt.dao;

import top.yuany3721.glxxxt.entity.Message;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
public interface MessageMapper extends BaseMapper<Message> {
    int addMessage(@Param("title") String title, @Param("content") String content, @Param("date") String date);

    List<Message> getAll();

}
