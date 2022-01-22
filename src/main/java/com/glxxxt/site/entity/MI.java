package com.glxxxt.site.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
@TableName("m_i")
public class MI implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品id
     */
    private Integer menuId;

    /**
     * 食材id
     */
    private Integer ingredientId;

    /**
     * 食材用量
     */
    private BigDecimal requirement;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public BigDecimal getRequirement() {
        return requirement;
    }

    public void setRequirement(BigDecimal remaining) {
        this.requirement = remaining;
    }

    @Override
    public String toString() {
        return "MI{" +
                "menuId=" + menuId +
                ", ingredientId=" + ingredientId +
                ", remaining=" + requirement +
                "}";
    }
}
