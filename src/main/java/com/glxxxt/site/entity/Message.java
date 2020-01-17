package com.glxxxt.site.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcl
 * @since 2019-10-23
 */
@TableName("message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 留言标题
     */
    private String title;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 时间
     */
    private String date;

    public Integer getId(){return  id;}

    public void setId(Integer id){this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id" + id +
        "title=" + title +
        ", content=" + content +
        ", date=" + date +
        "}";
    }
}
