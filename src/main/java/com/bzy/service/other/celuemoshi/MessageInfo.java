package com.bzy.service.other.celuemoshi;

public class MessageInfo {

    public MessageInfo(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    // 消息类型
    private Integer type;
    // 消息内容
    private String content;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}