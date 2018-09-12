package se.umu.cs.edu.rest;

import com.google.gson.Gson;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import se.umu.cs.edu.messenger.IMessengerImpl;
import se.umu.cs.edu.soa.hws.stubs.Message;

import java.util.HashMap;

public class RetrieveMessage extends ServerResource {

        @Get
        public String retrieveMessage(String entity) {
            String id = getQueryValue("id");

            IMessengerImpl rm = RestMessenger.getInstance();

            Message message1 = rm.retrieveMessage(id);

            HashMap<String, String> hashMap = new HashMap<>();

            hashMap.put("id", message1.getId());
            hashMap.put("timestamp", Long.toString(message1.getTimestamp()));
            hashMap.put("sender", message1.getSender());
            hashMap.put("topic", message1.getTopic());
            hashMap.put("content", message1.getContent());


            return new Gson().toJson(hashMap);
        }
    }

