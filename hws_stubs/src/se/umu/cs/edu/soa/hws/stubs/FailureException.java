/**
 * FailureException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package se.umu.cs.edu.soa.hws.stubs;

public class FailureException extends java.lang.Exception {
    private static final long serialVersionUID = 1536682855885L;
    private se.umu.cs.edu.soa.hws.stubs.FailureMessage faultMessage;

    public FailureException() {
        super("FailureException");
    }

    public FailureException(java.lang.String s) {
        super(s);
    }

    public FailureException(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public FailureException(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(se.umu.cs.edu.soa.hws.stubs.FailureMessage msg) {
        faultMessage = msg;
    }

    public se.umu.cs.edu.soa.hws.stubs.FailureMessage getFaultMessage() {
        return faultMessage;
    }
}
