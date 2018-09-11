package se.umu.cs.edu.soa.hws;

import se.umu.cs.edu.soa.hws.stubs.*;

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
        System.out.println("Usage:");
        System.out.println("  java GreetClient <name> <message>");
        return;
      }
      final String name    = args[0];
      final String message = args[1];
      final Greeting greeting = new Greeting(name, message);

      System.out.println("sending greeting");
      System.out.println("  " + greeting);

      // --- service invocation start ---
      // create client stub
      HelloWorldServiceStub stub = new HelloWorldServiceStub(url); 

      // create request
      GreetRequest request = new GreetRequest();
      request.setName(greeting.getName());
      request.setMessage(greeting.getMessage());

      Message message1 = new Message();
      message1.setId("qwertyuioplkjhgfdsazxcvbnmlkjhgf");
      message1.setContent("MEEESEAGE");
      message1.setSender("JJ");
      message1.setTopic("TREMORY");
      Byte thebyte = new Byte("5");
      message1.setAttachments(thebyte);

      // invoke service
      GreetResponse response = stub.greet(request); 

      // parse response
      Greeting reply = new Greeting(response.getName(),response.getMessage());
      System.out.println("received reply");
      System.out.println("  " + reply);
      // --- service invocation end ---
      stub.post(message1);


    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
