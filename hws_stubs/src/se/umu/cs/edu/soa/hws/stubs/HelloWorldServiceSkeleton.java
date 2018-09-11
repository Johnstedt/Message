/**
 * HelloWorldServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package se.umu.cs.edu.soa.hws.stubs;

import se.umu.cs.edu.soa.hws.Service;


/**
 *  HelloWorldServiceSkeleton java skeleton for the axisService
 */
public class HelloWorldServiceSkeleton {
    /**
     * Auto generated method signature
     *
     * @param greetRequest
     * @return greetResponse
     * @throws FailureException
     */
    public se.umu.cs.edu.soa.hws.stubs.GreetResponse greet(
        se.umu.cs.edu.soa.hws.stubs.GreetRequest greetRequest)
        throws FailureException {
        try {
            return Service.greet(greetRequest);
        } catch (Exception e) {
            throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#greet");
        }
    }

    /**
     * Auto generated method signature
     *
     * @param message
     * @return param0
     * @throws FailureException
     */
    public void post(se.umu.cs.edu.soa.hws.stubs.Message message)
        throws FailureException {
        Service.post(message);
    }
}
