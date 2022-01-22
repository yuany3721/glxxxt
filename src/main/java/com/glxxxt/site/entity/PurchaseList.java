package com.glxxxt.site.entity;

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
public class PurchaseList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 进货单id
     */
    private Integer id;

    /**
     * 食材名称
     */
    private String ingredientName;

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

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
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
        return "PurchaseList{" +
                "id=" + id +
                ", ingredientName=" + ingredientName +
                ", price=" + price +
                ", quantity=" + quantity +
                ", date=" + date +
                "}";
    }
}
