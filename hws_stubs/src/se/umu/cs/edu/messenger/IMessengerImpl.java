package se.umu.cs.edu.messenger;

import se.umu.cs.edu.soa.hws.stubs.Message;

import java.util.*;

public class IMessengerImpl implements IMessenger {

    private List<Message> messageList = new ArrayList<>();
    private Map<String, Set<String>> subscriptions = new HashMap<>();

    @Override
    public void postMessage(Message message) {
        messageList.add(message);
    }

    @Override
    public List listMessages(String topic) {
        List<String> list = new ArrayList<>();
        for(Message m : messageList){
            if(m.getTopic().equals(topic)){
                list.add(m.getId());
            }
        }
        return list;
    }

    @Override
    public Map listMessagesWithTimestamps(String topic) {
        Map<String, Long> map = new HashMap<>();

        for(Message m : messageList){
            if(m.getTopic().equals(topic)){
                map.put(m.getId(), m.getTimestamp());
            }
        }

        return map;
    }

    @Override
    public Message retrieveMessage(String id) {
        for(Message m : messageList){
            if(m.getId().equals(id)){
                return m;
            }
        }
        return null;
    }

    @Override
    public List listTopics() {

        List<String> list = new ArrayList<>();

        for(Message m : messageList){

            if(!list.contains(m.getTopic())){
                list.add(m.getTopic());
            }
        }
        return list;
    }

    @Override
    public boolean subscribe(String username, String topic) {

        if(subscriptions.containsKey(topic)){

            Set<String> set = subscriptions.get(topic);
            if(set.contains(username)){
                return false;
            }
            set.add(username);

            subscriptions.put(topic, set);
            return true;
        } else {
            Set<String> set = new HashSet<>();
            set.add(username);
            subscriptions.put(topic, set);
            return true;
        }
    }

    @Override
    public boolean unsubscribe(String username, String topic) {
        if(subscriptions.containsKey(topic)){

            Set<String> set = subscriptions.get(topic);
            if(set.contains(username)){
                set.remove(username);
                subscriptions.put(topic, set);

                return true;
            }
        }
        return false;
    }

    @Override
    public List listSubscribers(String topic) {
        List<String> list = new ArrayList<>();

        if(!subscriptions.containsKey(topic)){
            list.add("EMPTY");
            return list;
        }
        Set<String> set = subscriptions.get(topic);
        for(String s : set){
            list.add(s);
        }
        return list;
    }

    @Override
    public List listNodes() {
        return null;
    }

}