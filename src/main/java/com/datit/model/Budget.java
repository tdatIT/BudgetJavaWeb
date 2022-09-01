package com.datit.model;

import java.sql.Date;

public class Budget {
    private int id;
    private String title;
    private double value;
    private Date createDay;
    private int type;
    private int user_id;

    public Budget(int id, String title, double value, Date createDay, int type, int user_id) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.createDay = createDay;
        this.type = type;
        this.user_id = user_id;
    }

    public Budget(String title, double value, Date createDay, int type, int user_id) {
        this.title = title;
        this.value = value;
        this.createDay = createDay;
        this.type = type;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
