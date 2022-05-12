package top.yuany3721.glxxxt.dao;

import top.yuany3721.glxxxt.entity.Ingredient;

import java.math.BigDecimal;
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
public interface IngredientMapper extends BaseMapper<Ingredient> {
    List<Ingredient> getIngredient();

    BigDecimal getNowNum(Integer id);

    int updateIngredient(@Param("id") Integer id, @Param("remaining") BigDecimal num);

    List<Ingredient> getNeeded();

    String getName(Integer id);

}
