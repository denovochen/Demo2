package com.example.demo2;

public class item {

    String name;
    String opus;
    int image;

    public item(String name, String opus, int image) {
        this.name = name;
        this.opus = opus;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpus() {
        return opus;
    }

    public void setOpus(String opus) {
        this.opus = opus;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
