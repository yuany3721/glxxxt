package com.glxxxt.site.service.impl;

import com.glxxxt.site.dao.IngredientMapper;
import com.glxxxt.site.dao.MIMapper;
import com.glxxxt.site.entity.Ingredient;
import com.glxxxt.site.entity.MI;
import com.glxxxt.site.entity.Menu;
import com.glxxxt.site.dao.MenuMapper;
import com.glxxxt.site.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    public IngredientMapper ingredientMapper;
    @Autowired
    public MIMapper miMapper;

    @Override
    public List<Menu> getMenu() {
        //先检查是否有不可点的菜品
        List<Ingredient> temp = ingredientMapper.getIngredient();
        BigDecimal gogogogogo = BigDecimal.valueOf(0.05);
        for (Ingredient t : temp) {
            if (t.getRemaining().compareTo(gogogogogo) == -1 || t.getRemaining().compareTo(gogogogogo) == 0) {
                List<MI> tem = miMapper.getMenuId(t.getId());
                for (MI tt : tem) {
                    menuMapper.nodishes(tt.getMenuId());
                }
            }
        }
        return menuMapper.getMenu();
    }

}
