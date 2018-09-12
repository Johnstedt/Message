package se.umu.cs.edu.rest;

import com.google.gson.Gson;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import se.umu.cs.edu.messenger.IMessengerImpl;
import se.umu.cs.edu.soa.hws.stubs.Message;

import java.util.HashMap;

public class Subscribe extends ServerResource {

    @Post
    public String subscribe(String entity) {
        Gson gson = new Gson();
        HashMap<String, String> message = gson.fromJson(entity, HashMap.class);

        IMessengerImpl rm = RestMessenger.getInstance();

        boolean b = rm.subscribe(message.get("username"), message.get("topic"));

        HashMap<String, Boolean> response = new HashMap<>();
        response.put("status", b);

        return gson.toJson(response);
    }

}
