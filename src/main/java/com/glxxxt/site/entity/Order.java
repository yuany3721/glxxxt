package com.glxxxt.site.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
@TableName("order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 顾客订单id
     */
    private String id;

    /**
     * 菜品id
     */
    private Integer menuId;

    /**
     * 菜品名称
     */
    private String menuName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName(){return menuName;}

    public void setMenuName(String menuName){this.menuName = menuName;}

    @Override
    public String toString() {
        return "Order{" +
        "id=" + id +
        ", menuId=" + menuId +
        "}";
    }
}
