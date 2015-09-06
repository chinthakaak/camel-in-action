package com.examples;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.routepolicy.quartz.SimpleScheduledRoutePolicy;

import java.util.Date;

/**
 * Created by ka40215 on 9/4/15.
 */
public class RoutePolicyTest {
    public static void main(String[] args) throws Exception {
        final SimpleScheduledRoutePolicy policy = new SimpleScheduledRoutePolicy();
        long startTime = System.currentTimeMillis() + 3000L;
        policy.setRouteStartDate(new Date(startTime));
        policy.setRouteStartRepeatCount(1);
        policy.setRouteStartRepeatInterval(3000);

        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
//                        .setBody().simple("testing##############")
                        .routeId("test")

                        .routePolicy(policy)
                        .to("mock:success");
//                        .to("stream:out");

            }
        });

        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();

    }
}
