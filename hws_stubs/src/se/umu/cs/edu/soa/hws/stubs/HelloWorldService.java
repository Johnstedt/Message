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
     * @param greetRequest21
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public se.umu.cs.edu.soa.hws.stubs.GreetResponse greet(
        se.umu.cs.edu.soa.hws.stubs.GreetRequest greetRequest21)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    /**
     * Auto generated method signature
     *
     * @param message23
     * @throws se.umu.cs.edu.soa.hws.stubs.FailureException :
     */
    public void post(se.umu.cs.edu.soa.hws.stubs.Message message23)
        throws java.rmi.RemoteException,
            se.umu.cs.edu.soa.hws.stubs.FailureException;

    //
}
