package models;

import java.sql.Timestamp;

public class Test {

    private int id;
    private String name;
    private Integer status_id;
    private String method_name;
    private Integer project_id;
    private Integer session_id;
    private Timestamp start_time;
    private Timestamp end_time;
    private String env;
    private String browser;
    private Integer author_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatusId() {
        return status_id;
    }

    public void setStatusId(Integer status_id) {
        this.status_id = status_id;
    }

    public String getMethodName() {
        return method_name;
    }

    public void setMethodName(String method_name) {
        this.method_name = method_name;
    }

    public Integer getProjectId() {
        return project_id;
    }

    public void setProjectId(Integer project_id) {
        this.project_id = project_id;
    }

    public Integer getSessionId() {
        return session_id;
    }

    public void setSessionId(Integer session_id) {
        this.session_id = session_id;
    }

    public Timestamp getStartTime() {
        return start_time;
    }

    public void setStartTime(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEndTime() {
        return end_time;
    }

    public void setEndTime(Timestamp end_time) {
        this.end_time = end_time;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Integer getAuthorId() {
        return author_id;
    }

    public void setAuthorId(Integer author_id) {
        this.author_id = author_id;
    }

    public Test(int id, String name, Integer status_id, String method_name, Integer project_id, Integer session_id,
                Timestamp start_time, Timestamp end_time, String env, String browser, Integer author_id) {
        this.id = id;
        this.name = name;
        this.status_id = status_id;
        this.method_name = method_name;
        this.project_id = project_id;
        this.session_id = session_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.env = env;
        this.browser = browser;
        this.author_id = author_id;
    }

    public Test(String name, Integer status_id, String method_name, Integer project_id, Integer session_id,
                Timestamp start_time, Timestamp end_time, String env, String browser, Integer author_id) {
        this.name = name;
        this.status_id = status_id;
        this.method_name = method_name;
        this.project_id = project_id;
        this.session_id = session_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.env = env;
        this.browser = browser;
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status_id=" + status_id +
                ", method_name='" + method_name + '\'' +
                ", project_id=" + project_id +
                ", session_id=" + session_id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", env='" + env + '\'' +
                ", browser='" + browser + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}
