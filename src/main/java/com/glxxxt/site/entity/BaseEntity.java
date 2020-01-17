package com.glxxxt.site.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * @ClassName BaseEntity
 * @Description 实体公有基础类
 * @Author yanyi
 * @Date 2019/5/7 16:43
 * @Version 1.0
 **/
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 创建者
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private String createDate;
    /**
     * 更新者
     */
    @TableField("update_user")
    private String updateUser;
    /**
     * 更新时间
     */
    @TableField("update_date")
    private String updateDate;
    /**
     * 新闻类别
     */
    @TableField("news_type")
    private String newsType;


    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public BaseEntity() {

    }



    public BaseEntity(String createUser, String createDate, String updateUser, String updateDate, String newsType) {
        this.createUser = createUser;
        this.createDate = createDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
        this.newsType = newsType;
    }
}
