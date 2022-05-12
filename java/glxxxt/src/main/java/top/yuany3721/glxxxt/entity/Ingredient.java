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
@TableName("ingredient")
public class Ingredient implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 食材id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 食材名称
     */
    private String name;

    /**
     * 食材剩余量（斤）（个）（瓶）
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
