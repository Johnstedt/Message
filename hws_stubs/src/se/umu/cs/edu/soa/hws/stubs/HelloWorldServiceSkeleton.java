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
     * @param subscription
     * @return subscriptionResponse
     * @throws FailureException
     */
    public se.umu.cs.edu.soa.hws.stubs.SubscriptionResponse unsubscribe(
        se.umu.cs.edu.soa.hws.stubs.Subscription subscription)
        throws FailureException {
        try {
            return Service.unsubscribe(subscription);
        } catch (Exception e) {
            throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() +
                "#unsubscribe");
        }
    }

    /**
     * Auto generated method signature
     *
     * @param message
     * @return param1
     * @throws FailureException
     */
    public void postMessage(se.umu.cs.edu.soa.hws.stubs.Message message)
        throws FailureException {
        Service.postMessage(message);
    }

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
     * @param subscription2
     * @return subscription3
     * @throws FailureException
     */
    public se.umu.cs.edu.soa.hws.stubs.SubscriptionResponse subscribe(
        se.umu.cs.edu.soa.hws.stubs.Subscription subscription2)
        throws FailureException {
        try {
            return Service.subscribe(subscription2);
        } catch (Exception e) {
            throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#subscribe");
        }
    }

    /**
     * Auto generated method signature
     *
     * @param selector
     * @return message4
     * @throws FailureException
     */
    public se.umu.cs.edu.soa.hws.stubs.Message retrieveMessage(
        se.umu.cs.edu.soa.hws.stubs.Selector selector)
        throws FailureException {
        try {
            return Service.retrieveMessage(selector);
        } catch (Exception e) {
            throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() +
                "#retrieveMessage");
        }
    }

    /**
     * Auto generated method signature
     *
     * @param selector5
     * @return subscribers
     * @throws FailureException
     */
    public se.umu.cs.edu.soa.hws.stubs.Subscribers listSubscribers(
        se.umu.cs.edu.soa.hws.stubs.Selector selector5)
        throws FailureException {
        try {
            return Service.listSubscribers(selector5);
        } catch (Exception e) {
            throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() +
                "#listSubscribers");
        }
    }

    /**
     * Auto generated method signature
     *
     * @return topics
     * @throws FailureException
     */
    public se.umu.cs.edu.soa.hws.stubs.Topics listTopics()
        throws FailureException {
        try {
            return Service.listTopics();
        } catch (Exception e) {
            throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() +
                "#listTopics");
        }
    }

    /**
     * Auto generated method signature
     *
     * @param selector7
     * @return identifiers
     * @throws FailureException
     */
    public se.umu.cs.edu.soa.hws.stubs.Identifiers listMessages(
        se.umu.cs.edu.soa.hws.stubs.Selector selector7)
        throws FailureException {
        try {
            return Service.listMessages(selector7);
        } catch (Exception e) {
            throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() +
                "#listMessages");
        }
    }

    /**
     * Auto generated method signature
     *
     * @param selector8
     * @return timeStamps
     * @throws FailureException
     */
    public se.umu.cs.edu.soa.hws.stubs.TimeStamps listMessagesWithTimestamps(
        se.umu.cs.edu.soa.hws.stubs.Selector selector8)
        throws FailureException {
        try {
            return Service.listMessagesWithTimestamps(selector8);
        } catch (Exception e) {
            throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() +
                "#listMessagesWithTimestamps");
        }
    }
}
