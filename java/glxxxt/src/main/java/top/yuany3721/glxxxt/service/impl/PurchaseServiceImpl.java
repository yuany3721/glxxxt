package top.yuany3721.glxxxt.service.impl;

import top.yuany3721.glxxxt.entity.Ingredient;
import top.yuany3721.glxxxt.entity.Purchase;
import top.yuany3721.glxxxt.entity.PurchaseList;
import top.yuany3721.glxxxt.entity.MI;
import top.yuany3721.glxxxt.dao.IngredientMapper;
import top.yuany3721.glxxxt.dao.MIMapper;
import top.yuany3721.glxxxt.dao.MenuMapper;
import top.yuany3721.glxxxt.dao.PurchaseMapper;
import top.yuany3721.glxxxt.service.PurchaseService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
    @Autowired
    public PurchaseMapper purchaseMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    public IngredientMapper ingredientMapper;
    @Autowired
    public MIMapper miMapper;

    @Override
    public int purchase(Integer id, BigDecimal price, BigDecimal quantity) {
        String date = "";
        Date time = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.format(time);
        // 新加入的食材对应菜品更新
        List<Ingredient> temp = ingredientMapper.getIngredient();
        for (Ingredient t : temp) {
            List<MI> tem = miMapper.getMenuId(t.getId());
            for (MI tt : tem) {
                menuMapper.yesdishes(tt.getMenuId());
            }
        }
        return purchaseMapper.purchase(id, price, quantity, date);
    }

    @Override
    public List<PurchaseList> getList() {
        List<PurchaseList> list = new ArrayList<>();
        List<Purchase> tem = purchaseMapper.getAll();
        for (Purchase t : tem) {
            PurchaseList tt = new PurchaseList();
            tt.setId(t.getId());
            tt.setIngredientName(ingredientMapper.getName(t.getIngredientId()));
            tt.setPrice(t.getPrice());
            tt.setQuantity(t.getQuantity());
            tt.setDate(t.getDate());
            list.add(tt);
        }
        return list;
    }

}
