package com.glxxxt.site.dao;

import com.glxxxt.site.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
public interface OrderMapper extends BaseMapper<Order> {
    int newOrder(@Param("id") String id, @Param("menu_id") int menuId);

    List<Order> getOrder();
}
