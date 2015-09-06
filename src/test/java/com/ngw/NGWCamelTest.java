package com.ngw;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.cxf.message.MessageContentsList;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.ConnectionFactory;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ka40215 on 9/5/15.
 */
public class NGWCamelTest extends CamelSpringTestSupport {
//    @Override
//    protected RouteBuilder createRouteBuilder() throws Exception {
//        return new NGWTSNRouteBuilder();
//    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        AbstractApplicationContext abstractApplicationContext  = new ClassPathXmlApplicationContext("ngw-camel-context.xml");

        abstractApplicationContext.refresh();
        return abstractApplicationContext;
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        CamelContext ctx = super.createCamelContext();
        ctx.addRoutes(new NGWTSNRouteBuilder());

//        ctx.addComponent("",new NGWFrontEndImpl());
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
//        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        return ctx;
    }

    @Test
    public void testNGW() throws Exception {

        MockEndpoint ngwMock = getMockEndpoint("mock:ngwMock");
        ngwMock.expectedMessageCount(1);
//        template.sendBody("ngwNotificationEndpoint","1,test");

//        template.sendBodyAndHeader("ngwNotificationEndpoint", "1,abc","operationName","terminalStatusNotification");

//        MessageContentsList messageContentsList = (MessageContentsList) template.requestBodyAndHeader("ngwNotificationEndpoint", "x1000,abc","operationName","terminalStatusNotification");

        NGWFrontEnd ngwFrontEnd = initializeSoapServiceProxy(NGWFrontEnd.class, "http://localhost:9999/ngw?wsdl", "http://ngw.com/");
        ngwFrontEnd.terminalStatusNotification(10000,"kkkkkkkk");

        ngwMock.assertIsSatisfied();
//        Thread.sleep(10000);
    }

    @Test
    public void testJPA() throws Exception {
        MockEndpoint ngwMock = getMockEndpoint("mock:testMock");
        ngwMock.expectedMessageCount(1);
    }

    protected <T>T initializeSoapServiceProxy(Class<T> interfaceType, String wsdlURL, String targetNamespace) throws MalformedURLException {
        URL terminalStatusURL = new URL(wsdlURL);
        QName qname = new QName(targetNamespace, interfaceType.getSimpleName());
        Service service = Service.create(terminalStatusURL, qname);
        T proxy = service.getPort(interfaceType);
        return proxy;
    }
}
