package com.examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ka40215 on 7/25/15.
 */
public class FileCopierSpring {
    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("springcontext.xml");
        Thread.sleep(3000);
    }
}
