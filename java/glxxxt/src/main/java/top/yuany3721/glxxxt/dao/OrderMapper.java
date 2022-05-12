package top.yuany3721.glxxxt.dao;

import top.yuany3721.glxxxt.entity.Order;

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
public interface OrderMapper extends BaseMapper<Order> {
    int newOrder(@Param("id") String id, @Param("menu_id") int menuId);

    List<Order> getOrder();

}
