package com.glxxxt.site.service;

import com.glxxxt.site.entity.Ingredient;
import com.glxxxt.site.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
public interface IngredientService extends IService<Ingredient> {
    List<Ingredient> getIngredient();
    int addIngredient(Integer id, BigDecimal addnum);
    int cook(List<Menu> menu);
    List<Ingredient> getNeeded();
}
