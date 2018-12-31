package websevice;


import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.client.Transport;
import org.apache.axis.configuration.EngineConfigurationFactoryFinder;
import org.apache.axis.configuration.SimpleProvider;
import org.apache.axis.message.RPCHeaderParam;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.transport.http.CommonsHTTPSender;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.axis.transport.http.HTTPTransport;
import org.junit.Test;
import org.tempuri.Trans4JsonLocator;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by zhaoyipc on 2018/12/17.
 */
public class Axistest {
    @Test
    public void testaxis1_4()  {
        try {
            String endpoint = "http://testys.kito.cn/Trans4Json.asmx?wsdl";

            //创建一个服务（service）调用（call）
            Service service = new Service();
            Call call = (Call) service.createCall();
            //设置service所在的url
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperation("DataTrans_BaseData_Single");
            String ret = (String) call.invoke(new Object[]{"{\"basedatatypecode\":\"410201\",\"dept\":[{\"depcode\":\"abc1\",\"cdepname\":\"销售部\",\"deppartcode\":\"XXX4\",\"fybigtype\":\"1\",\"manageruid\":\"111\",\"manager_fenguanuid\":\"222\",\"gl_code\":\"123123123\",\"cdepmemo\":\"asdasd\",\"cdepcode\":\"D123\",\"cdeppartcode\":\"D12\",\"edittype\":0,\"editdate\":\"2017-07-25\"},{\"depcode\":\"abc2\",\"cdepname\":\"销售部\",\"deppartcode\":\"XXX4\",\"fybigtype\":\"1\",\"manageruid\":\"111\",\"manager_fenguanuid\":\"222\",\"gl_code\":\"123123123\",\"cdepmemo\":\"asdasd\",\"cdepcode\":\"D023\",\"cdeppartcode\":\"D02\",\"edittype\":1,\"editdate\":\"2017-07-25\"}]}"});
            System.out.println(ret);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void test1axis1_4()  {
        try {
            EngineConfiguration defaultConfig = EngineConfigurationFactoryFinder.newFactory().getClientEngineConfig();
            SimpleProvider config = new SimpleProvider(defaultConfig);
            config.deployTransport(HTTPTransport.DEFAULT_TRANSPORT_NAME,new CommonsHTTPSender());
            Trans4JsonLocator locator = new Trans4JsonLocator(config);

            String endpoint = "http://testys.kito.cn:80/Trans4Json.asmx";
//            String endpoint = "http://121.201.125.151/Trans4Json.asmx";

            //创建一个服务（service）调用（call）
            Service service = new Service();
            Call call = (Call) service.createCall();
//            call.addHeader(new SOAPHeaderElement("Content-Type","text/xml;charset=UTF-8"));
            //设置service所在的url
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
//            call.setProperty("axis.transport.version", HTTPConstants.HEADER_PROTOCOL_V11);
            //接口函数
            call.setOperationName(new QName("http://tempuri.org/","DataTrans_BaseData_Single"));
            call.setSOAPActionURI("http://tempuri.org/DataTrans_BaseData_Single");
            call.setUseSOAPAction(true);
            //接口的参数
//            call.addParameter(new QName("http://tempuri.org/","jsonTransData"), org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName("http://tempuri.org/","jsonTransData"), org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
            String jsonTransData=new String("{\"basedatatypecode\":\"410201\",\"dept\":[{\"depcode\":\"abc1\",\"cdepname\":\"销售部\",\"deppartcode\":\"XXX4\",\"fybigtype\":\"1\",\"manageruid\":\"111\",\"manager_fenguanuid\":\"222\",\"gl_code\":\"123123123\",\"cdepmemo\":\"asdasd\",\"cdepcode\":\"D123\",\"cdeppartcode\":\"D12\",\"edittype\":0,\"editdate\":\"2017-07-25\"},{\"depcode\":\"abc2\",\"cdepname\":\"销售部\",\"deppartcode\":\"XXX4\",\"fybigtype\":\"1\",\"manageruid\":\"111\",\"manager_fenguanuid\":\"222\",\"gl_code\":\"123123123\",\"cdepmemo\":\"asdasd\",\"cdepcode\":\"D023\",\"cdeppartcode\":\"D02\",\"edittype\":1,\"editdate\":\"2017-07-25\"}]}");
            //设置返回类型
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            String ret = (String) call.invoke(new Object[]{jsonTransData});
            Thread.sleep(20*1000);
            System.out.println(ret);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
