package com.patrickeng.words.app.model;

public class UserBo {

    private String userId;

    private int number;

    private String name;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("userId:" + userId + ",");
        sb.append("name:" + name + ",");
        return sb.toString();
    }


    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
}
