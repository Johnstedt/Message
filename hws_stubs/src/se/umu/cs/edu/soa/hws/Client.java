package se.umu.cs.edu.soa.hws;

import org.apache.axis2.mex.om.Identifier;
import se.umu.cs.edu.soa.hws.stubs.*;

import java.rmi.RemoteException;

/*
import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.axis2.*;
import org.apache.axis2.addressing.*;
import org.apache.axis2.client.*;
*/

public class Client
{
  private static final String DEFAULT_URL =
    "http://localhost:8080/axis2/services/HelloWorldService";


  //---------------------------------------------------------
  //---------------------------------------------------------
  private static String getProperty (String name)
  {
    String value = System.getProperty(name);
    return (value != null) ? value : "";
  }

  //---------------------------------------------------------
  public static void main (String args[])
  {
    try
    {
      final String propertyURL = getProperty("service.url");
      final String url = (propertyURL.length() > 0) ? propertyURL : DEFAULT_URL;


      if (args.length < 2)
      {

        if(!args[0].equals("listTopics")) {

          System.out.println("Usage:");
          System.out.println("  java SOAPClient <method> <arg> <arg> ...");
          return;
        }
      }

      // --- service invocation start ---
      // create client stub
      HelloWorldServiceStub stub = new HelloWorldServiceStub(url);
      handleMethod(args, stub);

      Message message1 = new Message();
      message1.setId("qwertyuioplkjhgfdsazxcvbnmlkjhgf");
      message1.setContent("MEEESEAGE");
      message1.setSender("JJ");
      message1.setTopic("TREMORY");


      // invoke service
      /*GreetResponse response = stub.greet(request);

      // parse response
      Greeting reply = new Greeting(response.getName(),response.getMessage());
      System.out.println("received reply");
      System.out.println("  " + reply);
      // --- service invocation end ---*/



    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

   private static void handleMethod(String args[], HelloWorldServiceStub stub){
      switch (args[0]){

        case "postMessage":
          postMessage(args, stub);

          break;
        case "retrieveMessage":
          retrieveMessage(args, stub);
          break;
        case "listMessage":
          listMessage(args, stub);
          break;
        case "listMessageWithTimestamps":
          listMessageWithTimestamps(args, stub);
          break;
        case "listTopics":
          listTopics(args, stub);
          break;
        case "subscribe":
          subscribe(args, stub);
          break;
        case "unsubscribe":
          unsubscribe(args, stub);
          break;
        case "listSubscribers":
          listSubscribers(args, stub);
          break;
        default:
          System.out.println("That service doesn't exist");

      }
  }

  private static void postMessage(String args[], HelloWorldServiceStub stub){

    if(args.length < 5){

      System.out.println("Usage:");
      System.out.println("java Client postMessage <id> <timestamp> <sender> <topic> <content> <attachment> ...");
      return;
    }

    Message message1 = new Message();
    message1.setId(args[1]);
    message1.setTimestamp(Long.valueOf(args[2]));
    message1.setSender(args[3]);
    message1.setTopic(args[4]);
    message1.setContent(args[5]);

    try {
      stub.postMessage(message1);
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (FailureException e) {
      e.printStackTrace();
    }

  }
  private static void retrieveMessage(String args[], HelloWorldServiceStub stub){

    if(args.length < 2){

      System.out.println("Usage:");
      System.out.println("java Client retrieveMessage <id>");
      return;
    }

    Selector s = new Selector();
    s.setMessage(args[1]);

    try {
      Message m = stub.retrieveMessage(s);

      System.out.println("Message:");
      System.out.println(m.getSender() + " on " + m.getTopic() + ": " + m.getContent() );

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (FailureException e) {
      e.printStackTrace();
    }

  }

  private static void listMessage(String[] args, HelloWorldServiceStub stub) {
    if(args.length < 2){

      System.out.println("Usage:");
      System.out.println("java Client retrieveMessage <topic>");
      return;
    }

    Selector selector = new Selector();
    selector.setMessage(args[1]);

    System.out.println("MESSAGE IDS FOR TOPIC " + args[1]);
    try {
      Identifiers ids = stub.listMessages(selector);

      for(String s : ids.getIdentifiers()){
        System.out.println(s);
      }

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (FailureException e) {
      e.printStackTrace();
    }
  }

  private static void listMessageWithTimestamps(String[] args, HelloWorldServiceStub stub) {
    if(args.length < 2){

      System.out.println("Usage:");
      System.out.println("java Client retrieveMessage <topic>");
      return;
    }

    Selector selector = new Selector();
    selector.setMessage(args[1]);

    System.out.println("MESSAGE TIMESTAMPS AND IDS FOR TOPIC " + args[1]);
    try {
      TimeStamps timeStamps = stub.listMessagesWithTimestamps(selector);

      String[] ids = timeStamps.getIdentifiers();
      long[] timestamps = timeStamps.getTimestamps();

      for(int i = 0; i < ids.length; i++){
        System.out.println(timestamps[i] + ": " +ids[i]);
      }

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (FailureException e) {
      e.printStackTrace();
    }
  }

  private static void listTopics(String[] args, HelloWorldServiceStub stub) {

    if(args.length > 1){

      System.out.println("Usage:");
      System.out.println("java Client listTopics");
      return;
    }

    try {
      Topics topics = stub.listTopics();
      for(String s : topics.getTopics()){
        System.out.println(s);
      }

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (FailureException e) {
      e.printStackTrace();
    }

  }

  private static void subscribe(String[] args, HelloWorldServiceStub stub) {
    if(args.length < 3){

      System.out.println("Usage:");
      System.out.println("java Client subscribe <username> <topic>");
      return;
    }

    Subscription subscription = new Subscription();
    subscription.setUsername(args[1]);
    subscription.setTopic(args[2]);

    try {
      SubscriptionResponse subresp = stub.subscribe(subscription);

      if(subresp.getResponse()){
        System.out.println("Subscription Successful");
      }else {
        System.out.println("Subscription Failed, maybe you're already a subscriber?");
      }

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (FailureException e) {
      e.printStackTrace();
    }


  }

  private static void unsubscribe(String[] args, HelloWorldServiceStub stub) {
    if(args.length < 3){

      System.out.println("Usage:");
      System.out.println("java Client unsubscribe <username> <topic>");
      return;
    }
    Subscription subscription = new Subscription();
    subscription.setUsername(args[1]);
    subscription.setTopic(args[2]);

    try {
      SubscriptionResponse subresp = stub.unsubscribe(subscription);

      if(subresp.getResponse()){
        System.out.println("Subscription cancellation Successful");
      }else {
        System.out.println("Subscription Failed, maybe you're aren't a subscriber?");
      }
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (FailureException e) {
      e.printStackTrace();
    }

  }

  private static void listSubscribers(String[] args, HelloWorldServiceStub stub) {
    if(args.length < 2){

      System.out.println("Usage:");
      System.out.println("java Client listSubscribers <topic>");
      return;
    }
    Selector selector = new Selector();
    selector.setMessage(args[1]);

    System.out.println("SUBSCRIBERS FOR TOPIC " + args[1]);
    try {
      Subscribers subs = stub.listSubscribers(selector);

      for (String s : subs.getTopics()){
        System.out.println(s);
      }

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (FailureException e) {
      e.printStackTrace();
    }


  }







}
