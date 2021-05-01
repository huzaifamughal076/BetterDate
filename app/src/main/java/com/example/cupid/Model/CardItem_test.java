package com.example.cupid.Model;

import android.graphics.drawable.Drawable;

public class CardItem_test {


    private String name;
    private String age;
    private String dp;
    private String description;
    private String id;

    public CardItem_test(String id,String description,String dp, String name, String age) {
        this.id=id;
        this.description=description;
        this.dp = dp;
        this.name = name;
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getDp() {
        return dp;
    }

    public void setAge(String age) {
        this.age = age;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }
}