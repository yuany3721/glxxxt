package com.glxxxt.site.controller;


import com.glxxxt.site.entity.Ingredient;
import com.glxxxt.site.entity.Menu;
import com.glxxxt.site.service.IngredientService;
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
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    public IngredientService ingredientService;

    @ResponseBody
    @RequestMapping(value = "/getIngredient",method = RequestMethod.POST)
    public List<Ingredient> getIngredient(){
        return ingredientService.getIngredient();
    }

    @ResponseBody
    @RequestMapping(value = "/addIngredient",method = RequestMethod.POST)
    public int addIngredient(@RequestParam("id") Integer id, @RequestParam("addnum") BigDecimal addnum){
        return ingredientService.addIngredient(id, addnum);
    }

    @ResponseBody
    @RequestMapping(value = "/cook", method = RequestMethod.POST)
    public int cook(@RequestBody List<Menu> menu){
        return ingredientService.cook(menu);
    }

    @ResponseBody
    @RequestMapping(value = "/getNeeded", method = RequestMethod.POST)
    public List<Ingredient> getNeeded(){
        return ingredientService.getNeeded();
    }
}

