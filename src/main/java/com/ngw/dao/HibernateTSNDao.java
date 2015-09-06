package com.ngw.dao;

import com.ngw.domain.TSN;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by ka40215 on 9/5/15.
 */
public class HibernateTSNDao extends HibernateDaoSupport implements TSNDao {
    public void save(TSN tsn) {
        getHibernateTemplate().save(tsn);

    }

    public void delete(TSN tpaEndpointReference) {

    }

    public void delete(String correlator, String applicationUserName) {

    }

    public List<TSN> findByCorrelator(String correlator) {
        return null;
    }

    public List<TSN> findByCorrelator(String correlator, String applicationUserName) {
        return null;
    }

    public boolean checkTableExists() {
        return false;
    }
}
