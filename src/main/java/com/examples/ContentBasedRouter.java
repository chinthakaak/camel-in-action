package com.examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ka40215 on 7/26/15.
 */
public class ContentBasedRouter {
    public static void main(String[] args) throws InterruptedException {
        new ClassPathXmlApplicationContext("spring-context.xml");
        Thread.sleep(1000);
    }
}
