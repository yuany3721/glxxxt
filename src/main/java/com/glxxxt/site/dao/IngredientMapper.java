package com.glxxxt.site.dao;

import com.glxxxt.site.entity.Ingredient;
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
public interface IngredientMapper extends BaseMapper<Ingredient> {
    List<Ingredient> getIngredient();
    BigDecimal getNowNum(Integer id);
    int updateIngredient(@Param("id") Integer id, @Param("remaining") BigDecimal num);
    List<Ingredient> getNeeded();
    String getName(Integer id);
}
