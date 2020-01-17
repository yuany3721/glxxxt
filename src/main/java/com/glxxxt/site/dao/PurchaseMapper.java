package com.glxxxt.site.dao;

import com.glxxxt.site.entity.Purchase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
public interface PurchaseMapper extends BaseMapper<Purchase> {
    int purchase(@Param("ingredient_id") Integer id, @Param("price") BigDecimal price, @Param("quantity") BigDecimal quantity, @Param("date") String date);
    List<Purchase> getAll();
}
