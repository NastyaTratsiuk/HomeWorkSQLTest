package models;

import java.sql.Timestamp;

public class Session {

    private int id;
    private String session_key;
    private Timestamp crated_time;
    private Integer build_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSessionKey() {
        return session_key;
    }

    public void setSessionKey(String session_key) {
        this.session_key = session_key;
    }

    public Timestamp getCratedTime() {
        return crated_time;
    }

    public void setCratedTime(Timestamp crated_time) {
        this.crated_time = crated_time;
    }

    public Integer getBuild_number() {
        return build_number;
    }

    public void setBuildNumber(Integer build_number) {
        this.build_number = build_number;
    }

    public Session(String session_key, Timestamp crated_time, Integer build_number) {
        this.session_key = session_key;
        this.crated_time = crated_time;
        this.build_number = build_number;
    }

    @Override
    public String toString() {
        return "SessionTable{" +
                "session_key='" + session_key + '\'' +
                ", crated_time='" + crated_time + '\'' +
                ", build_number=" + build_number +
                '}';
    }
}
