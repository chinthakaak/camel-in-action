package com.ngw.dao;

import com.ngw.domain.TSN;

import java.util.List;

/**
 * Created by ka40215 on 9/5/15.
 */
public interface TSNDao {
    void save(TSN tsn);

    void delete(TSN tsn);

    void delete(String correlator, String applicationUserName);

    List<TSN> findByCorrelator(String correlator);

    List<TSN> findByCorrelator(String correlator, String applicationUserName);

    boolean checkTableExists();
}
