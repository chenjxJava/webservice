# webService
### 一、ws发布HelloService
<pre>
wsdl地址：http://localhost:8989/WS_Server/WebService?wsdl
</pre>
### 二、HelloService四个方法
<pre>
1.String say()
2.String sayHello(String name)
3.String putNameAndAge(String name, String age)
4.List&lt;User> getUserList()
注：User是自定义类型
</pre>

### 三、使用cxf动态调用
<pre>
package com.chenjx.util;

/**
 * create by chenjx 2018/8/14
 */
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.util.StringUtils;

public class CxfUtils {


    /**
     *
     * 调用webservice 接口
     *
     * @param wsdlUrl  wsdl 地址
     *
     * @param method  调用方法名
     *
     * @param params  接口传入参数
     *
     * @return
     *
     */
    public static synchronized Object[] invoke(String wsdlUrl,String method,Object... params){

        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient(wsdlUrl);

        Object[] objects = null;

        if(StringUtils.isEmpty(wsdlUrl)){

            System.out.println("cxf 调用webservice 参数缺失：wsdl url 未传入");
            return objects;
        }

        if(StringUtils.isEmpty(method)){

            System.out.println("cxf 调用webservice 执行方法名缺失：method 未传入");
            return objects;
        }

        try {

            objects=client.invoke(method,params);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cxf 调用webservice 执行错误：" + e);

        }

        return objects;
    }
}

/**
  测试类
*/
package com.chenjx.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class CxfUtilsTest {

    @Test
    public void testSay() {
        String url = "http://localhost:8989/WS_Server/WebService?wsdl";
//            String url = "http://10.220.105.185:8090/PudongDEP/services/HydroData?wsdl";
//            String method = "getStatData";
        String method = "say";
//            Object[] parameters = new Object[]{"CFA760,18102", "20180327235000", "20180328000000","Water&dataSource", "REAL_CYZX"};
        // Object[] parameters = new Object[]{"REAL_CYZX"};
        Object[] invoke = CxfUtils.invoke(url, method, null);
        System.out.println(invoke[0]);
    }

    @Test
    public void testSayHello() {
        String url = "http://localhost:8989/WS_Server/WebService?wsdl";
//            String url = "http://10.220.105.185:8090/PudongDEP/services/HydroData?wsdl";
//            String method = "getStatData";
        String method = "sayHello";
//            Object[] parameters = new Object[]{"CFA760,18102", "20180327235000", "20180328000000","Water&dataSource", "REAL_CYZX"};
        Object[] parameters = new Object[]{"REAL_CYZX"};
        Object[] invoke = CxfUtils.invoke(url, method, parameters);
        System.out.println(invoke[0]);
    }

    @Test
    public void invoke() {
        String url = "http://localhost:8989/WS_Server/WebService?wsdl";
//            String url = "http://10.220.105.185:8090/PudongDEP/services/HydroData?wsdl";
//            String method = "getStatData";
        String method = "putNameAndAge";
//            Object[] parameters = new Object[]{"CFA760,18102", "20180327235000", "20180328000000","Water&dataSource", "REAL_CYZX"};
        Object[] parameters = new Object[]{"REAL_CYZX"};

        Object[] invoke = CxfUtils.invoke(url, method, "guangbai", "24");
        System.out.println(invoke[0]);
    }

    /**
     * 【垃圾】
     * 对方接口返回了自定义类对象，就用不了了
     */
    @Test
    public void invoke5() {
        String url = "http://localhost:8989/WS_Server/WebService?wsdl";
//            String url = "http://10.220.105.185:8090/PudongDEP/services/HydroData?wsdl";
//            String method = "getStatData";
        String method = "getUserList";
//            Object[] parameters = new Object[]{"CFA760,18102", "20180327235000", "20180328000000","Water&dataSource", "REAL_CYZX"};
        Object[] parameters = new Object[]{"REAL_CYZX"};

        Object[] invoke = CxfUtils.invoke(url, method, null);
        System.out.println(invoke[0]);
    }


    @Test
    public void invoke4() {
        String url = "http://10.220.105.185:8090/PudongDEP/services/HydroData?wsdl";
//        String method = "getStatData";
//        String method = "sayHello";
        String method = "getStatData";
            Object[] parameters = new Object[]{"CFA760,18102", "20180327235000", "20180328000000","Water","dataSource", "REAL_CYZX"};
//        Object[] parameters = new Object[]{"REAL_CYZX"};
//        Object[] invoke = CxfUtils.invoke(url, method,
//                "CFA760,18102","20180327235000","20180328000000","Water","REAL_CYZX");
        Object[] invoke = CxfUtils.invoke(url, method, parameters);
        System.out.println(invoke);
    }
}
</pre>

### 四、静态调用
<pre>
// cxf进行客户端代码生成
wsdl2java -d com/ -o e:/2018081401 -client http://localhost:8989/WS_Server/WebService?wsdl

// axis2生成客户端代码
wsdl2java -uri http://10.220.105.185:8090/PudongDEP/services/PrivilegeControl/webserviceLogin?password=pdsw323006 -p com.axis -o e:\20180814  
</pre>