package com.ngw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.rmi.Naming;

/**
 * Created by ka40215 on 9/5/15.
 */
@Entity
@Table(name = "TSNOTIFICATIONS")
public class TSN {

    private int phoneNumber;
    private String correlator;
    private String sessionId;
    private int count;
    private int countRunning;
    private int duration;
    private int durationRunning;
    private int status;
    private String endpoint;
    private String applicationUserName;

    @Column(name = "PHONENUMBER")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column( name = "CORRELATOR")
    public String getCorrelator() {
        return correlator;
    }

    public void setCorrelator(String correlator) {
        this.correlator = correlator;
    }

    @Column( name = "SESSIONID")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Column( name = "COUNT")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Column( name = "COUNTR")
    public int getCountRunning() {
        return countRunning;
    }

    public void setCountRunning(int countRunning) {
        this.countRunning = countRunning;
    }

    @Column( name = "DURATION")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column( name = "DURATIONR")
    public int getDurationRunning() {
        return durationRunning;
    }

    public void setDurationRunning(int durationRunning) {
        this.durationRunning = durationRunning;
    }

    @Column( name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column( name = "ENDPOINT")
    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Id
    @Column( name = "APPLICATIONUSERNAME")
    public String getApplicationUserName() {
        return applicationUserName;
    }

    public void setApplicationUserName(String applicationUserName) {
        this.applicationUserName = applicationUserName;
    }
//    @Column(name = "endpointURI")
//    public String getEndpointURI() {
//        return endpointURI;
//    }
//
//    public void setEndpointURI(final String endpointURI) {
//        this.endpointURI = endpointURI;
//    }
//
//    @Column(name = "correlator")
//    public String getCorrelator() {
//        return correlator;
//    }
//
//    public void setCorrelator(final String correlator) {
//        this.correlator = correlator;
//    }
//
//    @Column(name = "applicationUserName")
//    public String getApplicationUserName() {
//        return applicationUserName;
//    }
//
//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(final Long id) {
//        this.id = id;
//    }
//
//    public void setApplicationUserName(final String applicationUserName) {
//        this.applicationUserName = applicationUserName;
//    }
}
