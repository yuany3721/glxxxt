package top.yuany3721.glxxxt.service.impl;

import top.yuany3721.glxxxt.entity.Ingredient;
import top.yuany3721.glxxxt.entity.MI;
import top.yuany3721.glxxxt.entity.Menu;
import top.yuany3721.glxxxt.dao.IngredientMapper;
import top.yuany3721.glxxxt.dao.MIMapper;
import top.yuany3721.glxxxt.service.IngredientService;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
@Service
public class IngredientServiceImpl extends ServiceImpl<IngredientMapper, Ingredient> implements IngredientService {
    @Autowired
    public IngredientMapper ingredientMapper;
    @Autowired
    public MIMapper miMapper;

    @Override
    public List<Ingredient> getIngredient() {
        return ingredientMapper.getIngredient();
    }

    @Override
    public int addIngredient(Integer id, BigDecimal addnum) {
        BigDecimal nownum = ingredientMapper.getNowNum(id);
        return ingredientMapper.updateIngredient(id, nownum.add(addnum));
    }

    @Override
    public int cook(List<Menu> menu) {
        for (Menu obj : menu) {
            List<MI> temp = miMapper.getRequirement(obj.getId());
            for (MI t : temp) {
                BigDecimal nownum = ingredientMapper.getNowNum(t.getIngredientId());
                ingredientMapper.updateIngredient(t.getIngredientId(), nownum.subtract(t.getRequirement()));
            }
        }
        return 1;
    }

    @Override
    public List<Ingredient> getNeeded() {
        return ingredientMapper.getNeeded();
    }

}
