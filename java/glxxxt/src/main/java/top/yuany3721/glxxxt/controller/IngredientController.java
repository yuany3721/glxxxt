package top.yuany3721.glxxxt.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.yuany3721.glxxxt.entity.Menu;
import top.yuany3721.glxxxt.service.IngredientService;
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
public class IngredientController {
    @Autowired
    public IngredientService ingredientService;

    /**
     * @return
     */
    @GetMapping("/getIngredient")
    public Response<?> getIngredient() {
        return Response.success(ingredientService.getIngredient());
    }

    /**
     * @param id
     * @param addnum
     * @return
     */
    @PostMapping("/addIngredient")
    public Response<?> addIngredient(@RequestParam("id") Integer id,
            @RequestParam("addnum") BigDecimal addnum) {
        return Response.success(ingredientService.addIngredient(id, addnum));
    }

    /**
     * @param menu
     * @return
     */
    @PostMapping("/cook")
    public Response<?> cook(@RequestBody List<Menu> menu) {
        return Response.success(ingredientService.cook(menu));
    }

    /**
     * @return
     */
    @GetMapping("/getNeededIngredient")
    public Response<?> getNeeded() {
        return Response.success(ingredientService.getNeeded());
    }
}
