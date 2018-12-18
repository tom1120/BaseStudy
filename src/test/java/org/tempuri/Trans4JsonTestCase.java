/**
 * Trans4JsonTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Trans4JsonTestCase extends junit.framework.TestCase {
    public Trans4JsonTestCase(String name) {
        super(name);
    }

    public void testTrans4JsonSoapWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new Trans4JsonLocator().getTrans4JsonSoapAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new Trans4JsonLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1Trans4JsonSoapHelloWorld() throws Exception {
        Trans4JsonSoapStub binding;
        try {
            binding = (Trans4JsonSoapStub)
                          new Trans4JsonLocator().getTrans4JsonSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.helloWorld();
        // TBD - validate results
    }

    public void test2Trans4JsonSoapDataTrans_Bill_Single() throws Exception {
        Trans4JsonSoapStub binding;
        try {
            binding = (Trans4JsonSoapStub)
                          new Trans4JsonLocator().getTrans4JsonSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.dataTrans_Bill_Single(new String());
        // TBD - validate results
    }

    public void test3Trans4JsonSoapDataTrans_BaseData_Single() throws Exception {
        Trans4JsonSoapStub binding;
        try {
            binding = (Trans4JsonSoapStub)
                          new Trans4JsonLocator().getTrans4JsonSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.dataTrans_BaseData_Single(new String());
        // TBD - validate results
    }

    public void test4Trans4JsonSoapDataTrans_Bill_Array() throws Exception {
        Trans4JsonSoapStub binding;
        try {
            binding = (Trans4JsonSoapStub)
                          new Trans4JsonLocator().getTrans4JsonSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.dataTrans_Bill_Array(new String());
        // TBD - validate results
    }

    public void test5Trans4JsonSoapDataTrans_BaseData_Array() throws Exception {
        Trans4JsonSoapStub binding;
        try {
            binding = (Trans4JsonSoapStub)
                          new Trans4JsonLocator().getTrans4JsonSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.dataTrans_BaseData_Array(new String());
        // TBD - validate results
    }

    public void testTrans4JsonSoap12WSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new Trans4JsonLocator().getTrans4JsonSoap12Address() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new Trans4JsonLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test6Trans4JsonSoap12HelloWorld() throws Exception {
        org.tempuri.Trans4JsonSoap12Stub binding;
        try {
            binding = (org.tempuri.Trans4JsonSoap12Stub)
                          new Trans4JsonLocator().getTrans4JsonSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.helloWorld();
        // TBD - validate results
    }

    public void test7Trans4JsonSoap12DataTrans_Bill_Single() throws Exception {
        org.tempuri.Trans4JsonSoap12Stub binding;
        try {
            binding = (org.tempuri.Trans4JsonSoap12Stub)
                          new Trans4JsonLocator().getTrans4JsonSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.dataTrans_Bill_Single(new String());
        // TBD - validate results
    }

    public void test8Trans4JsonSoap12DataTrans_BaseData_Single() throws Exception {
        org.tempuri.Trans4JsonSoap12Stub binding;
        try {
            binding = (org.tempuri.Trans4JsonSoap12Stub)
                          new Trans4JsonLocator().getTrans4JsonSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.dataTrans_BaseData_Single(new String());
        // TBD - validate results
    }

    public void test9Trans4JsonSoap12DataTrans_Bill_Array() throws Exception {
        org.tempuri.Trans4JsonSoap12Stub binding;
        try {
            binding = (org.tempuri.Trans4JsonSoap12Stub)
                          new Trans4JsonLocator().getTrans4JsonSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.dataTrans_Bill_Array(new String());
        // TBD - validate results
    }

    public void test10Trans4JsonSoap12DataTrans_BaseData_Array() throws Exception {
        org.tempuri.Trans4JsonSoap12Stub binding;
        try {
            binding = (org.tempuri.Trans4JsonSoap12Stub)
                          new Trans4JsonLocator().getTrans4JsonSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.dataTrans_BaseData_Array(new String());
        // TBD - validate results
    }

}
