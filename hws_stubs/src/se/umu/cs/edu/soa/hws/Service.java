package se.umu.cs.edu.soa.hws;

import org.apache.axis2.mex.om.Identifier;
import se.umu.cs.edu.messenger.IMessenger;
import se.umu.cs.edu.messenger.IMessengerImpl;
import se.umu.cs.edu.soa.hws.stubs.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Service
{
  private static final String SERVICE =
    "http://cs.umu.se/edu/soa/HelloWorldService";

  private static IMessenger iMessenger = new IMessengerImpl();

  //---------------------------------------------------------
  public static GreetResponse greet (GreetRequest greetRequest)
    throws FailureException
  {
    try
    {
      GreetResponse response = new GreetResponse();
      response.setName("hello world service");
      response.setMessage("hello " + greetRequest.getName());
      return response;
    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

  public static void postMessage(Message message)
          throws FailureException
  {
    try
    {
      iMessenger.postMessage(message);
      System.out.println(message.getContent());
    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

  public static Identifiers listMessages(Selector s)
          throws FailureException
  {
    try
    {

      List list = iMessenger.listMessages(s.getMessage());

      String arr[] = new String[list.size()];

      for(int i = 0; i < list.size(); i++){
        arr[i] = (String)list.get(i);
      }
      Identifiers ids = new Identifiers();
      ids.setIdentifiers(arr);
      return ids;


      //System.out.println(iMessenger.retrieveMessage(message.getId()).getContent());
    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

  public static TimeStamps listMessagesWithTimestamps(Selector selector)
          throws FailureException
  {
    try
    {
      Map<String, Long> map = (Map<String, Long>) iMessenger.listMessagesWithTimestamps(selector.getMessage());

      long timestamps[] = new long[map.size()];
      String ids[] = new String[map.size()];

      int i = 0;
      for (Map.Entry entry : map.entrySet())
      {

        ids[i] = (String)entry.getKey();
        timestamps[i] = (Long) entry.getValue();
        i++;
      }

      TimeStamps ts = new TimeStamps();
      ts.setIdentifiers(ids);
      ts.setTimestamps(timestamps);
      return ts;
    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

  public static Message retrieveMessage(Selector selector)
          throws FailureException
  {
    try
    {
      return iMessenger.retrieveMessage(selector.getMessage());
    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

  public static Topics listTopics()
          throws FailureException
  {
    try
    {
      List list = iMessenger.listTopics();
      String arr[] = new String[list.size()];
      for(int i = 0; i < list.size(); i++){
        arr[i] = (String)list.get(i);
      }
      Topics topics = new Topics();
      topics.setTopics(arr);
      return topics;

    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

  public static SubscriptionResponse subscribe(Subscription subscription)
          throws FailureException
  {
    try
    {
        boolean b = iMessenger.subscribe(subscription.getUsername(), subscription.getTopic());
        SubscriptionResponse sr = new SubscriptionResponse();
        sr.setResponse(b);
        return sr;
    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

  public static SubscriptionResponse unsubscribe(Subscription subscription)
          throws FailureException
  {
    try
    {
      boolean b = iMessenger.unsubscribe(subscription.getUsername(), subscription.getTopic());
      SubscriptionResponse sp = new SubscriptionResponse();
      sp.setResponse(b);
      return sp;
    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

  public static Subscribers listSubscribers(Selector selector)
          throws FailureException
  {
    try
    {
      List list = iMessenger.listSubscribers(selector.getMessage());
      Subscribers subs = new Subscribers();
      String[] arr = new String[list.size()];
      for(int i = 0; i < list.size(); i++){
        arr[i] = (String)list.get(i);
      }
      subs.setTopics(arr);
      return subs;

    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }

}
