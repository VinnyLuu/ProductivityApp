package com.example.vinny.productivityapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SessionHistory implements Serializable {

    private ArrayList<Session> sessionHistory;
    final static private String FILENAME = "Sessionhistory.sav";

    public SessionHistory() {
        sessionHistory = new ArrayList<Session>();
    }

    public ArrayList<Session> getSessionHistory() {
        return sessionHistory;
    }

    public void addSession(Session session) {
        sessionHistory.add(session);
    }

    public int getSessionIndex(Session session) {
        return sessionHistory.indexOf(session);
    }

    public Session getASession(int index) {
        return sessionHistory.get(index);
    }

    public void deleteIndexSession(int index) {
        sessionHistory.remove(index);
    }

    public void deleteObjectSession(Session session) {
        sessionHistory.remove(session);
    }

    /* Method used to load the EmotionHistory from the save file*/
    public SessionHistory loadFromFile(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
            Gson gson = new Gson();
            Type sessionHistoryType = new TypeToken<SessionHistory>() {
            }.getType();
            SessionHistory sessionHistory = gson.fromJson(reader, sessionHistoryType);
            return sessionHistory;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            SessionHistory sessionHistory = new SessionHistory();
            return sessionHistory;
        }

    }

    /* Method used to save the EmotionHistory into the save file*/
    public void saveInFile(Context context, SessionHistory sessionHistory) {
        try {
            // FILE OUTPUTSTREAM makes a byte stream
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            // Char stream
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            // Buffer stream
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            gson.toJson(sessionHistory, writer);
            writer.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


