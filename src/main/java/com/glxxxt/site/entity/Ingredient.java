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
@TableName("ingredient")
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 食材id
     */
    private Integer id;

    /**
     * 食材名称
     */
    private String name;

    /**
     * 食材剩余量（斤）
     */
    private BigDecimal remaining;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name=" + name +
                ", remaining=" + remaining +
                "}";
    }
}
