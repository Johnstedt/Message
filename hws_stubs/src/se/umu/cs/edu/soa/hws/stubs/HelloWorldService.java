/**
 * HelloWorldService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package se.umu.cs.edu.soa.hws.stubs;


/*
 *  HelloWorldService java interface
 */
public interface HelloWorldService {
    /**
     * Auto generated method signature
     *
     * @param subscription98
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.SubscriptionResponse unsubscribe(
        se.umu.cs.edu.soa.hws.stubs.Subscription subscription98)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @param message100
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public void postMessage(se.umu.cs.edu.soa.hws.stubs.Message message100)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @param greetRequest102
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.GreetResponse greet(
        se.umu.cs.edu.soa.hws.stubs.GreetRequest greetRequest102)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @param subscription104
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.SubscriptionResponse subscribe(
        se.umu.cs.edu.soa.hws.stubs.Subscription subscription104)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @param selector106
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.Message retrieveMessage(
        se.umu.cs.edu.soa.hws.stubs.Selector selector106)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @param selector108
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.Subscribers listSubscribers(
        se.umu.cs.edu.soa.hws.stubs.Selector selector108)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.Topics listTopics()
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @param selector112
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.Identifiers listMessages(
        se.umu.cs.edu.soa.hws.stubs.Selector selector112)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @param selector114
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.TimeStamps listMessagesWithTimestamps(
        se.umu.cs.edu.soa.hws.stubs.Selector selector114)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    //
}
