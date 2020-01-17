package com.glxxxt.site.controller;


import com.glxxxt.site.entity.Menu;
import com.glxxxt.site.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "/getMenu",method = RequestMethod.POST)
    public List<Menu> list(){
        List<Menu> list = menuService.getMenu();
        return list;
    }

}

