package com.ngw;

import com.ngw.domain.TSN;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ka40215 on 9/5/15.
 */
public class NGWTSNRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("cxf:bean:ngwNotificationEndpoint").routeId("ngwNotification")
//        .to("mock:ngwMock");

        from("jpa://com.ngw.domain.TSN?consumeDelete=false&delay=3000&consumeLockEntity=false")
//                .to("mock:ngwMock").log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!${body}");
        .to("file://data/customers/test.txt");

//        from("direct:test")
//                .pollEnrich("jpa://" + TSN.class.getName() + "?consumer.query=select u from com.ngw.domain.TSN u&consumeDelete=false")
//                .to("mock:testMock")
//                .to("file:data/customers/test.txt");


    }
}
