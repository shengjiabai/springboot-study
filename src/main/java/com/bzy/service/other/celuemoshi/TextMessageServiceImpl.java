package com.bzy.service.other.celuemoshi;

import org.springframework.stereotype.Service;

/**
 * 处理文本消息
 */
@Service
@MsgTypeHandler(value = MSG_TYPE.TEXT)
public class TextMessageServiceImpl implements MessageService {

    @Override
    public void handleMessage(MessageInfo messageInfo) {
        System.out.println("处理文本消息 " + messageInfo.getContent());
    }
}