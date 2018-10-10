package com.example.vinny.productivityapp;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Session implements Serializable {

    private Time sessionTime;
    private String sessionName;
    private Date sessionDate;

    public Session(Time sessionTime, String sessionName){
        this.sessionName = sessionName;
        this.sessionTime = sessionTime;
        this.sessionDate = new Date();
    }

    public String getSessionName() {
        return sessionName;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public Time getSessionTime() {
        return sessionTime;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setSessionTime(Time sessionTime) {
        this.sessionTime = sessionTime;
    }


}
