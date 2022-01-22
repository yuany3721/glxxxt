package com.glxxxt.site.controller;


import com.glxxxt.site.entity.Order;
import com.glxxxt.site.entity.Menu;
import com.glxxxt.site.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public int newOrder(@RequestBody List<Menu> menu) {
        return orderService.newOrder(menu);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrder", method = RequestMethod.POST)
    public List<Order> getOrder() {
        return orderService.getOrder();
    }
}

