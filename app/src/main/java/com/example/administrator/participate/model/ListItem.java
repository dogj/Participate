package com.example.administrator.participate.model;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ListItem {
    private String titles;
    private int imageResId;
    private String level;
    private String sign;
    private String record;

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public int getImageResId() {

        return imageResId;
    }

    public String getTitles() {
        return titles;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
