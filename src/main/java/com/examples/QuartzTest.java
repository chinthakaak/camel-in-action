package com.examples;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by ka40215 on 9/4/15.
 */
public class QuartzTest {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
//                from("timer://myTimer?period=2000")
//                        .setBody().simple("Current time is ${header.firedTime}")
//                        .to("stream:out");

                String str="2000";
                from("quartz://myTimer2?trigger.repeatInterval={{str}}&trigger.repeatCount=6")
                        .setBody().simple("Current time is ${header.fireTime}")
                        .to("stream:out");


            }
        });

        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }
}
