package com.glxxxt.site.service;

import com.glxxxt.site.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcl
 * @since 2019-10-23
 */
public interface MessageService extends IService<Message> {
    int addMessage(String title, String message);
    List<Message> getAll();
}
