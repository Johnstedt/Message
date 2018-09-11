package se.umu.cs.edu.soa.hws;

import se.umu.cs.edu.soa.hws.stubs.*;

public class Service
{
  private static final String SERVICE =
    "http://cs.umu.se/edu/soa/HelloWorldService";


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

  public static void post(Message message)
          throws FailureException
  {
    try
    {
      System.out.println(message.getSender());
    }
    catch (Exception e)
    {
      throw new FailureException("Operation Failure",e);
    }
  }
}
