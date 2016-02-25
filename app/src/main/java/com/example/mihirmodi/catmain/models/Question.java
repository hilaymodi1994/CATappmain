package com.example.mihirmodi.catmain.models;

public class Question {
    private int id;
    private String header;
    private String content;
    private String imageUrl;
    private String answerText;
    private String imageUrlAns;
    private String year;
    private String name;
    private int attempted; //this attribute does not belong to database.used as a flag in question details activity for setting the spinner view.
    private boolean marked;

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public Question() {
        this.attempted = 0;
    }

    public int getAttempted() {
        return attempted;
    }

    public void setAttempted(int attempted) {
        this.attempted = attempted;
    }

    private int tid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getImageUrlAns() {
        return imageUrlAns;
    }

    public void setImageUrlAns(String imageUrlAns) {
        this.imageUrlAns = imageUrlAns;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}