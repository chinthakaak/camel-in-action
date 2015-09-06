package com.ngw;

import javax.jws.WebService;

/**
 * Created by ka40215 on 9/5/15.
 */
@WebService//(endpointInterface = "com.ngw.NGWFrontEnd")
public class NGWFrontEndImpl implements NGWFrontEnd {
    public void terminalStatusNotification(int sessionId, String result) {
        System.out.println(result);
    }
}
