package top.yuany3721.glxxxt.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.yuany3721.glxxxt.service.PurchaseService;
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
public class PurchaseController {
    @Autowired
    public PurchaseService purchaseService;

    @PostMapping("/purchase")
    public Response<?> purchase(@RequestParam("id") Integer id,
            @RequestParam("price") BigDecimal price,
            @RequestParam("quantity") BigDecimal quantity) {
        return Response.success(purchaseService.purchase(id, price, quantity));
    }

    @GetMapping("/getPurchaseList")
    public Response<?> getList() {
        return Response.success(purchaseService.getList());
    }

}
