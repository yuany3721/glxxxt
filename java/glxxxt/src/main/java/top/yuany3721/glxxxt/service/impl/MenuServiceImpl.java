package top.yuany3721.glxxxt.service.impl;

import top.yuany3721.glxxxt.entity.Ingredient;
import top.yuany3721.glxxxt.entity.Menu;
import top.yuany3721.glxxxt.entity.MI;
import top.yuany3721.glxxxt.dao.IngredientMapper;
import top.yuany3721.glxxxt.dao.MIMapper;
import top.yuany3721.glxxxt.dao.MenuMapper;
import top.yuany3721.glxxxt.service.MenuService;

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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    public IngredientMapper ingredientMapper;
    @Autowired
    public MIMapper miMapper;

    @Override
    public List<Menu> getMenu() {
        // 先检查是否有不可点的菜品
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
