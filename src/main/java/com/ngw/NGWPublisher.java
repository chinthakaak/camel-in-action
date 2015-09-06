package com.ngw;

import javax.xml.ws.Endpoint;

/**
 * Created by ka40215 on 9/5/15.
 */
public class NGWPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ngw", new NGWFrontEndImpl());
    }
}
