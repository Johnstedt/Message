/**
 * HelloWorldServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package se.umu.cs.edu.soa.hws.stubs;


/**
 *  HelloWorldServiceMessageReceiverInOut message receiver
 */
public class HelloWorldServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            HelloWorldServiceSkeleton skel = (HelloWorldServiceSkeleton) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("greet".equals(methodName)) {
                    se.umu.cs.edu.soa.hws.stubs.GreetResponse greetResponse10 = null;
                    se.umu.cs.edu.soa.hws.stubs.GreetRequest wrappedParam = (se.umu.cs.edu.soa.hws.stubs.GreetRequest) fromOM(msgContext.getEnvelope()
                                                                                                                                        .getBody()
                                                                                                                                        .getFirstElement(),
                            se.umu.cs.edu.soa.hws.stubs.GreetRequest.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    greetResponse10 = skel.greet(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            greetResponse10, false,
                            new javax.xml.namespace.QName(
                                "http://cs.umu.se/edu/soa/hws/stubs", "greet"));
                } else if ("post".equals(methodName)) {
                    se.umu.cs.edu.soa.hws.stubs.Message wrappedParam = (se.umu.cs.edu.soa.hws.stubs.Message) fromOM(msgContext.getEnvelope()
                                                                                                                              .getBody()
                                                                                                                              .getFirstElement(),
                            se.umu.cs.edu.soa.hws.stubs.Message.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    skel.post(wrappedParam);

                    envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (FailureException e) {
            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,
                "FailureMessage");

            org.apache.axis2.AxisFault f = createAxisFault(e);

            if (e.getFaultMessage() != null) {
                f.setDetail(toOM(e.getFaultMessage(), false));
            }

            throw f;
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(
        se.umu.cs.edu.soa.hws.stubs.GreetRequest param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(se.umu.cs.edu.soa.hws.stubs.GreetRequest.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        se.umu.cs.edu.soa.hws.stubs.GreetResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(se.umu.cs.edu.soa.hws.stubs.GreetResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        se.umu.cs.edu.soa.hws.stubs.FailureMessage param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(se.umu.cs.edu.soa.hws.stubs.FailureMessage.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        se.umu.cs.edu.soa.hws.stubs.Message param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(se.umu.cs.edu.soa.hws.stubs.Message.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        se.umu.cs.edu.soa.hws.stubs.GreetResponse param,
        boolean optimizeContent, javax.xml.namespace.QName methodQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    se.umu.cs.edu.soa.hws.stubs.GreetResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private se.umu.cs.edu.soa.hws.stubs.GreetResponse wrapgreet() {
        se.umu.cs.edu.soa.hws.stubs.GreetResponse wrappedElement = new se.umu.cs.edu.soa.hws.stubs.GreetResponse();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type, java.util.Map extraNamespaces)
        throws org.apache.axis2.AxisFault {
        try {
            if (se.umu.cs.edu.soa.hws.stubs.FailureMessage.class.equals(type)) {
                return se.umu.cs.edu.soa.hws.stubs.FailureMessage.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (se.umu.cs.edu.soa.hws.stubs.GreetRequest.class.equals(type)) {
                return se.umu.cs.edu.soa.hws.stubs.GreetRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (se.umu.cs.edu.soa.hws.stubs.GreetResponse.class.equals(type)) {
                return se.umu.cs.edu.soa.hws.stubs.GreetResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (se.umu.cs.edu.soa.hws.stubs.Message.class.equals(type)) {
                return se.umu.cs.edu.soa.hws.stubs.Message.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    /**
     *  A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(
        org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();

        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }

        return returnMap;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class
