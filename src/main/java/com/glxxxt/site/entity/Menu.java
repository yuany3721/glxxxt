package com.glxxxt.site.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
@TableName("menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜品名称
     */
    private String dishes;

    /**
     * 菜品类型
     */
    private String type;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 是否上架 0：否 1：是
     */
    private Boolean availableFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailableFlag() {
        return availableFlag;
    }

    public void setAvailableFlag(Boolean availableFlag) {
        this.availableFlag = availableFlag;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", type=" + type +
                ", price=" + price +
                ", availableFlag=" + availableFlag +
                "}";
    }

}
