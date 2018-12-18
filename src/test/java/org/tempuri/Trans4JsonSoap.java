/**
 * Trans4JsonSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface Trans4JsonSoap extends java.rmi.Remote {
    public String helloWorld() throws java.rmi.RemoteException;
    public String dataTrans_Bill_Single(String jsonTransData) throws java.rmi.RemoteException;
    public String dataTrans_BaseData_Single(String jsonTransData) throws java.rmi.RemoteException;
    public String dataTrans_Bill_Array(String jsonTransData) throws java.rmi.RemoteException;
    public String dataTrans_BaseData_Array(String jsonTransData) throws java.rmi.RemoteException;
}
