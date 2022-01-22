package com.glxxxt.site.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.glxxxt.site.entity.Menu;
import com.glxxxt.site.entity.Order;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
public interface OrderService extends IService<Order> {

    int newOrder(List<Menu> menu);

    List<Order> getOrder();
}
