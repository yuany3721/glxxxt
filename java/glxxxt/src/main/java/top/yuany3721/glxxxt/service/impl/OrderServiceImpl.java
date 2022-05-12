package top.yuany3721.glxxxt.service.impl;

import top.yuany3721.glxxxt.entity.Menu;
import top.yuany3721.glxxxt.entity.Order;
import top.yuany3721.glxxxt.dao.MenuMapper;
import top.yuany3721.glxxxt.dao.OrderMapper;
import top.yuany3721.glxxxt.service.OrderService;

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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    public OrderMapper orderMapper;
    @Autowired
    public MenuMapper menuMapper;

    @Override
    public int newOrder(List<Menu> menu) {
        String id = "";
        Date time = new Date();
        // System.out.println(22222);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        id = dateFormat.format(time);
        // System.out.println(id);
        for (Menu obj : menu) {
            if (orderMapper.newOrder(id, obj.getId()) == 1)
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
        for (Order t : tem) {
            Order tt = new Order();
            tt.setId(t.getId());
            tt.setMenuId(t.getMenuId());
            tt.setMenuName(menuMapper.getDishName(t.getMenuId()));
            res.add(tt);
        }
        return res;
    }

}
