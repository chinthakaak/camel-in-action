package com.ngw.dao;

import com.ngw.domain.TSN;
import com.util.HibernateUtil;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by ka40215 on 9/5/15.
 */
public class TSNDaoTest {
    @Test
    public void testHibernateOracle(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TSN tsn = new TSN();

        tsn.setApplicationUserName("tsuser2");
        tsn.setCount(2);
        tsn.setEndpoint("http://ts");
        tsn.setCorrelator("cor005");
        tsn.setCountRunning(2);
        tsn.setDuration(10);
        tsn.setDurationRunning(10);
        tsn.setPhoneNumber(1236);
        tsn.setSessionId("ses002");
        tsn.setStatus(1);

        session.save(tsn);
        session.getTransaction().commit();

        List list= session.createCriteria(TSN.class).list();
    }

    @Test
    public void testQuery(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List list= session.createCriteria(TSN.class).list();
    }

}
