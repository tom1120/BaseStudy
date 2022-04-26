package org.wso2.carbon.sample.admin.service.invoker;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.wso2.carbon.um.ws.api.stub.RemoteTenantManagerServiceStub;
import org.wso2.carbon.um.ws.api.stub.UserStoreExceptionException;

import java.rmi.RemoteException;

public class RemoteTenantManagerServiceClient {

    private final String serviceName = "RemoteTenantManagerService";
    private RemoteTenantManagerServiceStub remoteTenantManagerServiceStub;
    private String endPoint;

    public RemoteTenantManagerServiceClient(String backEndUrl, String sessionCookie) throws AxisFault {
        this.endPoint = backEndUrl + "/services/" + serviceName;
        remoteTenantManagerServiceStub = new RemoteTenantManagerServiceStub(endPoint);
        //Authenticate Your stub from sessionCooke
        ServiceClient serviceClient;
        Options option;

        serviceClient = remoteTenantManagerServiceStub._getServiceClient();
        option = serviceClient.getOptions();
        option.setManageSession(true);
        option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, sessionCookie);
    }


    public void deactivateTenant(int tenantId) throws UserStoreExceptionException, RemoteException {

        remoteTenantManagerServiceStub.deactivateTenant(tenantId);

    }


    public void deleteTenant(int tenantId) throws UserStoreExceptionException, RemoteException {

        remoteTenantManagerServiceStub.deleteTenant(tenantId);

    }


}
