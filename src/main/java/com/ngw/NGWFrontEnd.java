package com.ngw;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by ka40215 on 9/5/15.
 */
@WebService(serviceName = "NGWFrontEnd")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface NGWFrontEnd {
    @WebMethod
    void terminalStatusNotification(int sessionId, String result);
}
