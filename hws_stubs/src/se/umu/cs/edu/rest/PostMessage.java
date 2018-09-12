package se.umu.cs.edu.rest;

import com.google.gson.Gson;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import se.umu.cs.edu.messenger.IMessengerImpl;
import se.umu.cs.edu.soa.hws.stubs.Message;

import java.util.HashMap;

public class PostMessage extends ServerResource {

    @Post
    public String postMessage(String entity) {
        Gson gson = new Gson();
        HashMap<String, String> message = gson.fromJson(entity, HashMap.class);

        IMessengerImpl rm = RestMessenger.getInstance();

        Message message1 = new Message();
        message1.setId(message.get("id"));
        message1.setContent(message.get("content"));
        message1.setTopic(message.get("topic"));
        message1.setSender(message.get("sender"));
        message1.setTimestamp(Long.parseLong(message.get("timestamp")));

        rm.postMessage(message1);

        return "";
    }
}