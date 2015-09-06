package com.ngw;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by ka40215 on 9/5/15.
 */
public class NGW {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ngw?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://ngw.com/", "NGWFrontEndImplService");

        Service service = Service.create(url, qname);

        NGWFrontEnd ngwFrontEnd = service.getPort(NGWFrontEnd.class);

       ngwFrontEnd.terminalStatusNotification(1222,"result");
    }
}
