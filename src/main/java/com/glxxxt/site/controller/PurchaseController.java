package com.glxxxt.site.controller;


import com.glxxxt.site.entity.PurchaseList;
import com.glxxxt.site.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    public PurchaseService purchaseService;
    @ResponseBody
    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public int purchase(@RequestParam(value = "id",required = false) Integer id, @RequestParam(value = "price",required = false) BigDecimal price, @RequestParam(value = "quantity",required = false) BigDecimal quantity){
        return purchaseService.purchase(id, price, quantity);
    }
    @ResponseBody
    @RequestMapping(value = "getList", method = RequestMethod.POST)
    public List<PurchaseList> getList(){
        return purchaseService.getList();
    }
}

