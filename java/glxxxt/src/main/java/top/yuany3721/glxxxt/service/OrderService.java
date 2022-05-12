package top.yuany3721.glxxxt.service;

import top.yuany3721.glxxxt.entity.Menu;
import top.yuany3721.glxxxt.entity.Order;

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
public interface OrderService extends IService<Order> {

    int newOrder(List<Menu> menu);

    List<Order> getOrder();

}
