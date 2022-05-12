package top.yuany3721.glxxxt.dao;

import top.yuany3721.glxxxt.entity.Purchase;

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
public interface PurchaseMapper extends BaseMapper<Purchase> {
    int purchase(@Param("ingredient_id") Integer id, @Param("price") BigDecimal price,
            @Param("quantity") BigDecimal quantity, @Param("date") String date);

    List<Purchase> getAll();

}
