package top.yuany3721.glxxxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.yuany3721.glxxxt.service.MessageService;
import top.yuany3721.glxxxt.util.Response;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
@RestController
@RequestMapping()
public class MessageController {
    @Autowired
    public MessageService messageService;

    @PostMapping("/addMessage")
    public Response<?> addMessage(String title, String content) {
        return Response.success(messageService.addMessage(title, content));
    }

    @GetMapping("/getAllMessage")
    public Response<?> getAll() {
        return Response.success(messageService.getAll());
    }

}
