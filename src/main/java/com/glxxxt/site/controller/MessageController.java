package com.glxxxt.site.controller;

import com.glxxxt.site.entity.Message;
import com.glxxxt.site.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lcl
 * @since 2019-10-23
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    public MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public int addMessage(String title, String content) {
        return messageService.addMessage(title, content);
    }

    @ResponseBody
    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public List<Message> getAll() {
        return messageService.getAll();
    }

}

