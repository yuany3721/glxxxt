package top.yuany3721.glxxxt.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
@TableName("m_i")
public class MI implements Serializable {

private static final long serialVersionUID=1L;

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

    public void setRequirement(BigDecimal requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "MI{" +
        "menuId=" + menuId +
        ", ingredientId=" + ingredientId +
        ", requirement=" + requirement +
        "}";
    }
}
