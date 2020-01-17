package com.glxxxt.site.service.impl;

import com.glxxxt.site.dao.IngredientMapper;
import com.glxxxt.site.dao.MIMapper;
import com.glxxxt.site.dao.MenuMapper;
import com.glxxxt.site.dao.PurchaseMapper;
import com.glxxxt.site.dao.*;
import com.glxxxt.site.entity.Ingredient;
import com.glxxxt.site.entity.MI;
import com.glxxxt.site.entity.Purchase;
import com.glxxxt.site.entity.PurchaseList;
import com.glxxxt.site.service.PurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
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
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.format(time);
        //新加入的食材对应菜品更新
        List<Ingredient> temp = ingredientMapper.getIngredient();
        BigDecimal gogogogogo=BigDecimal.valueOf(0.05);
        for(Ingredient t : temp){
                List<MI> tem = miMapper.getMenuId(t.getId());
                for(MI tt : tem){
                    menuMapper.yesdishes(tt.getMenuId());
            }
        }
        return purchaseMapper.purchase(id, price, quantity,date);
    }

    @Override
    public List<PurchaseList> getList() {
        List<PurchaseList> list = new ArrayList<>();
        List<Purchase> tem = purchaseMapper.getAll();
        for(Purchase t : tem){
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
