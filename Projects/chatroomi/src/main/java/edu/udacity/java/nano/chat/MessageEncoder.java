package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {
    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(Message msg) throws EncodeException {
        // Access msgA's properties and convert to JSON text...
        return JSON.toJSONString(msg);
    }
}