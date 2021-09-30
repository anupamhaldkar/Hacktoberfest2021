package edu.udacity.java.nano;

import edu.udacity.java.nano.chat.Message;
import edu.udacity.java.nano.chat.WebSocketChatServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.websocket.Session;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**     Credentials - I took inspiration from
        *  https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example
        * forums -
        *  https://stackoverflow.com/questions/49846627/how-to-correctly-mock-a-websocket-session
        *
 * */

@RunWith(SpringRunner.class)
@WebMvcTest(WebSocketChatApplication.class)
public class TestWebSocketChatApplication {

    @Mock
    Session session;
    @Mock
    WebSocketChatServer webSocketChatServer;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void login() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void join() throws Exception{
        String request = "/?username=anupam";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/index").content(request))
                .andExpect(status().isOk())
                .andExpect(view().name("chat"));
    }

    @Test
    public void chat() throws Exception{
        session = mock(Session.class);

        Message message = new Message();
        message.setFrom("anupam");
        message.setContent("Knock! knock! Hello everyone??");

        when(session.isOpen()).thenReturn(true);

        webSocketChatServer = new WebSocketChatServer();
        webSocketChatServer.onMessage(session, message);

        Assert.assertEquals("SPEAK",message.getType());
    }

    @Test
    public void leave() throws Exception{
        when(session.isOpen()).thenReturn(true);

        webSocketChatServer.onClose(session);

        when(session.isOpen()).thenReturn(false);
    }


}
