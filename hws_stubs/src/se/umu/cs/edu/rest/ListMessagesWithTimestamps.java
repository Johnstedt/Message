package se.umu.cs.edu.rest;

import com.google.gson.Gson;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import se.umu.cs.edu.messenger.IMessengerImpl;
import se.umu.cs.edu.soa.hws.stubs.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMessagesWithTimestamps extends ServerResource {

    @Get
    public String listMessageWithTimestamps() {
        String topic = getQueryValue("topic");

        IMessengerImpl rm = RestMessenger.getInstance();

        Map map = rm.listMessagesWithTimestamps(topic);

        return new Gson().toJson(map);
    }

}
