package top.yuany3721.glxxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.yuany3721.glxxxt.entity.Menu;
import top.yuany3721.glxxxt.service.OrderService;
import top.yuany3721.glxxxt.util.Response;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
@RestController
@RequestMapping()
public class OrderController {
    @Autowired
    public OrderService orderService;

    @PostMapping("/newOrder")
    public Response<?> newOrder(@RequestBody List<Menu> menu) {
        return Response.success(orderService.newOrder(menu));
    }

    @GetMapping("/getOrder")
    public Response<?> getOrder() {
        return Response.success(orderService.getOrder());
    }

}
