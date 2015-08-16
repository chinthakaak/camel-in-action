package com.examples;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

/**
 * Created by ka40215 on 7/25/15.
 */
public class FileToJMS {
    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        ctx.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:data/inbox?noop=true")
                        .to("jms:fileQueue")
                        .process(new Processor() {
                            public void process(Exchange exchange) throws Exception {
                                System.out.println(exchange.getIn().getBody());
                            }
                        })
                        .to("file:data/jmsout1");

                from("jms:fileQueue")
                        .to("file:data/jmsout2");
            }
        });

        ctx.start();
        Thread.sleep(1000);
        ctx.stop();
    }
}
