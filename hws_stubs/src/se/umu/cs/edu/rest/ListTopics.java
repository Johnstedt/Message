package se.umu.cs.edu.rest;

import com.google.gson.Gson;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import se.umu.cs.edu.messenger.IMessengerImpl;

import java.util.List;

public class ListTopics extends ServerResource {

    @Get
    public String listTopics() {

        IMessengerImpl rm = RestMessenger.getInstance();

        List list = rm.listTopics();
        return new Gson().toJson(list);
    }
}
