package top.yuany3721.glxxxt.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
@TableName("purchase")
public class Purchase implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 进货单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 食材id
     */
    private Integer ingredientId;

    /**
     * 采购价格
     */
    private BigDecimal price;

    /**
     * 采购数量（斤）
     */
    private BigDecimal quantity;

    /**
     * 采购日期
     */
    private String date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
        "id=" + id +
        ", ingredientId=" + ingredientId +
        ", price=" + price +
        ", quantity=" + quantity +
        ", date=" + date +
        "}";
    }
}
