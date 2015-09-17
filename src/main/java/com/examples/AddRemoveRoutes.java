package com.examples;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by ka40215 on 9/17/15.
 */
public class AddRemoveRoutes {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.start();

        final String interval = "1000";
        RouteBuilder r1 = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("quartz://myTimer1?trigger.repeatInterval="+interval+"&trigger.repeatCount=12")
                        .setBody().simple("Current time1 is ${header.fireTime}")
                        .to("stream:out")
                        .routeId("r1");

            }
        };

        RouteBuilder r2 = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("quartz://myTimer2?trigger.repeatInterval=1000&trigger.repeatCount=12")
                        .setBody().simple("Current time2 is ${header.fireTime}")
                        .to("stream:out")
                        .routeId("r2");
            }
        };

        camelContext.addRoutes(r1);
        Thread.sleep(3000);
        camelContext.addRoutes(r2);
        Thread.sleep(3000);
        camelContext.stopRoute("r1");
//        camelContext.removeRoute("r1");
        Thread.sleep(20000);
        camelContext.stop();
    }
}
