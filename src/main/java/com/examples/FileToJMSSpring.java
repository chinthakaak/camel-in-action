package com.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ka40215 on 7/25/15.
 */
public class FileToJMSSpring {
    public static void main(String[] args) throws Exception {
        ApplicationContext springctx = new ClassPathXmlApplicationContext("filejms.xml");
        Thread.sleep(1000);
//        ((ClassPathXmlApplicationContext)springctx).stop();
    }
}
