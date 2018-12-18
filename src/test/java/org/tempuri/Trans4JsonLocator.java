/**
 * Trans4JsonLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Trans4JsonLocator extends org.apache.axis.client.Service implements Trans4Json {

    public Trans4JsonLocator() {
    }


    public Trans4JsonLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Trans4JsonLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Trans4JsonSoap
    private String Trans4JsonSoap_address = "http://testys.kito.cn/Trans4Json.asmx";

    public String getTrans4JsonSoapAddress() {
        return Trans4JsonSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String Trans4JsonSoapWSDDServiceName = "Trans4JsonSoap";

    public String getTrans4JsonSoapWSDDServiceName() {
        return Trans4JsonSoapWSDDServiceName;
    }

    public void setTrans4JsonSoapWSDDServiceName(String name) {
        Trans4JsonSoapWSDDServiceName = name;
    }

    public Trans4JsonSoap getTrans4JsonSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Trans4JsonSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrans4JsonSoap(endpoint);
    }

    public Trans4JsonSoap getTrans4JsonSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.Trans4JsonSoapStub _stub = new org.tempuri.Trans4JsonSoapStub(portAddress, this);
            _stub.setPortName(getTrans4JsonSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTrans4JsonSoapEndpointAddress(String address) {
        Trans4JsonSoap_address = address;
    }


    // Use to get a proxy class for Trans4JsonSoap12
    private String Trans4JsonSoap12_address = "http://testys.kito.cn/Trans4Json.asmx";

    public String getTrans4JsonSoap12Address() {
        return Trans4JsonSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private String Trans4JsonSoap12WSDDServiceName = "Trans4JsonSoap12";

    public String getTrans4JsonSoap12WSDDServiceName() {
        return Trans4JsonSoap12WSDDServiceName;
    }

    public void setTrans4JsonSoap12WSDDServiceName(String name) {
        Trans4JsonSoap12WSDDServiceName = name;
    }

    public Trans4JsonSoap getTrans4JsonSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Trans4JsonSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrans4JsonSoap12(endpoint);
    }

    public Trans4JsonSoap getTrans4JsonSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.Trans4JsonSoap12Stub _stub = new org.tempuri.Trans4JsonSoap12Stub(portAddress, this);
            _stub.setPortName(getTrans4JsonSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTrans4JsonSoap12EndpointAddress(String address) {
        Trans4JsonSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Trans4JsonSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.Trans4JsonSoapStub _stub = new org.tempuri.Trans4JsonSoapStub(new java.net.URL(Trans4JsonSoap_address), this);
                _stub.setPortName(getTrans4JsonSoapWSDDServiceName());
                return _stub;
            }
            if (Trans4JsonSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.Trans4JsonSoap12Stub _stub = new org.tempuri.Trans4JsonSoap12Stub(new java.net.URL(Trans4JsonSoap12_address), this);
                _stub.setPortName(getTrans4JsonSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("Trans4JsonSoap".equals(inputPortName)) {
            return getTrans4JsonSoap();
        }
        else if ("Trans4JsonSoap12".equals(inputPortName)) {
            return getTrans4JsonSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Trans4Json");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "Trans4JsonSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "Trans4JsonSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("Trans4JsonSoap".equals(portName)) {
            setTrans4JsonSoapEndpointAddress(address);
        }
        else 
if ("Trans4JsonSoap12".equals(portName)) {
            setTrans4JsonSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
