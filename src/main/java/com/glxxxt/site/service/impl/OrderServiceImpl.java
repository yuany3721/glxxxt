package com.glxxxt.site.service.impl;

import com.glxxxt.site.dao.OrderMapper;
import com.glxxxt.site.dao.MenuMapper;
import com.glxxxt.site.entity.Menu;
import com.glxxxt.site.entity.Order;
import com.glxxxt.site.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    public OrderMapper orderMapper;
    @Autowired
    public MenuMapper menuMapper;

    @Override
    public int newOrder(List<Menu> menu) {
        String id = "";
        Date time = new Date();
        //System.out.println(22222);
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        id = dateFormat.format(time);
        //System.out.println(id);
        for (Menu obj : menu) {
            if (orderMapper.newOrder(id,obj.getId()) == 1)
                continue;
            else
                return 0;
        }
        return 1;
    }

    @Override
    public List<Order> getOrder() {
        List<Order> tem = orderMapper.getOrder();
        List<Order> res = new ArrayList<>();
        for(Order t : tem){
            Order tt = new Order();
            tt.setId(t.getId());
            tt.setMenuId(t.getMenuId());
            tt.setMenuName(menuMapper.getDishName(t.getMenuId()));
            res.add(tt);
        }
        return res;
    }

}
