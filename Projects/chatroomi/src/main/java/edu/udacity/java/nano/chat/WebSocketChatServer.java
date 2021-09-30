package edu.udacity.java.nano.chat;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session

 *  https://www.baeldung.com/java-websockets
 * github/source code repositories -
 *  https://github.com/eugenp/tutorials/tree/master/java-websocket
 *  https://enterprise.gitee.com/ShuaiPang/codes/ftbyvq0n63hewusr4l98j51
 *
 */

@Component
@ServerEndpoint(value = "/chat/{username}", decoders = MessageDecoder.class,
        encoders = MessageEncoder.class )
public class WebSocketChatServer {

    /**
     * All chat sessions.
     *
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
    private static Map<String, String> users = new ConcurrentHashMap<>();

    public Map<String, String> getUsers() {
        return new ConcurrentHashMap<>(users);
    }

    private static void sendMessageToAll(Message message) throws IOException, EncodeException {
        onlineSessions.forEach((sId, ss) -> {
            try{
                ss.getBasicRemote().sendObject(message);
            }catch (IOException | EncodeException e){
            e.printStackTrace();
        }
        });
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException {
        onlineSessions.putIfAbsent(session.getId(), session);
        users.putIfAbsent(session.getId(), username);

        Message message = new Message();
        message.setFrom("Chat Room: ");
        message.setContent(username +" joined!");
        message.setType("");
        message.setOnlineCount(""+users.size());
        sendMessageToAll(message);


    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        message.setType("SPEAK");
        sendMessageToAll(message);
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        onlineSessions.remove(session.getId());


        Message message = new Message();
        message.setFrom("Chat Room: ");
        message.setContent(users.get(session.getId()) + " disconnected!");
        message.setType("");

        users.remove(session.getId());
        message.setOnlineCount(""+users.size());
        sendMessageToAll(message);

    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
