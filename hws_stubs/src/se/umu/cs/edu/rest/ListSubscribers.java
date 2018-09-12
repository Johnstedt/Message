package se.umu.cs.edu.rest;

import com.google.gson.Gson;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import se.umu.cs.edu.messenger.IMessengerImpl;
import se.umu.cs.edu.soa.hws.stubs.Message;

import java.util.HashMap;
import java.util.List;

public class ListSubscribers extends ServerResource {

    @Get
    public String listSubscribers() {
        String topic = getQueryValue("topic");

        IMessengerImpl rm = RestMessenger.getInstance();

        List list = rm.listSubscribers(topic);
        return new Gson().toJson(list);
    }

}
