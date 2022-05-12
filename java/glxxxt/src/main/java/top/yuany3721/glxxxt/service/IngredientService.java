package top.yuany3721.glxxxt.service;

import top.yuany3721.glxxxt.entity.Ingredient;
import top.yuany3721.glxxxt.entity.Menu;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
public interface IngredientService extends IService<Ingredient> {
    List<Ingredient> getIngredient();

    int addIngredient(Integer id, BigDecimal addnum);

    int cook(List<Menu> menu);

    List<Ingredient> getNeeded();

}
