package edu.udacity.java.nano.chat;

/**
 * WebSocket message model
 */

public class Message {
    private String content;
    private String from; //sender name
    private String type; //SPEAK - if it's set to "SPEAK", this message will be broadcasted to all by the server
    private String onlineCount;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(String onlineCount) {
        this.onlineCount = onlineCount;
    }


}
