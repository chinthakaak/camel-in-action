package com.examples;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by ka40215 on 7/25/15.
 */
public class FileCopier {
    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:/data/data/inbox?noop=true")
                        .to("file:/data/data/outbox");
            }
        });

        ctx.start();
        Thread.sleep(1000);
        ctx.stop();
    }
}
