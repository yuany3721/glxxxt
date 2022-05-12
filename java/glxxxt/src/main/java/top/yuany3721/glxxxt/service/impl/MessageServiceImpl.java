package top.yuany3721.glxxxt.service.impl;

import top.yuany3721.glxxxt.entity.Message;
import top.yuany3721.glxxxt.dao.MessageMapper;
import top.yuany3721.glxxxt.service.MessageService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Autowired
    public MessageMapper messageMapper;

    @Override
    public int addMessage(String title, String message) {
        String date = "";
        Date time = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = dateFormat.format(time);
        return messageMapper.addMessage(title, message, date);
    }

    @Override
    public List<Message> getAll() {
        return messageMapper.getAll();
    }

}
