package com.example.mihirmodi.catmain.models;

public class Tests {
    private int id;
    private String name;
    private long allowedTime;
    public Tests(){
        this.id=id ;
        this.name=name ;
        this.allowedTime=allowedTime;
    }
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
    public long getAllowedTime() {
        return allowedTime;
    }
    public void setAllowedTime(long allowed_time) {
        this.allowedTime = allowed_time;
    }
}