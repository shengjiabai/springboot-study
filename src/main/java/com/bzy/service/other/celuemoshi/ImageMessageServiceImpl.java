package com.bzy.service.other.celuemoshi;

import org.springframework.stereotype.Service;

@Service
@MsgTypeHandler(value = MSG_TYPE.IMAGE)
public class ImageMessageServiceImpl implements MessageService {

    @Override
    public void handleMessage(MessageInfo messageInfo) {
        System.out.println("处理图片消息 " + messageInfo.getContent());
    }
}