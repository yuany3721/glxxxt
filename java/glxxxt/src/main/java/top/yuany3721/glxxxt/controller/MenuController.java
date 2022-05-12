package top.yuany3721.glxxxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.yuany3721.glxxxt.service.MenuService;
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
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/getMenu")
    public Response<?> list() {
        return Response.success(menuService.getMenu());
    }

}
