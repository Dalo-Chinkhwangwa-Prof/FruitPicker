package com.britishbroadcast.mylistapp.model;

public class Fruit {
    private String image;
    private String name;
    private int calories;
    private String benefits;

    public Fruit(String image, String name, int calories, String benefits) {
        this.image = image;
        this.name = name;
        this.calories = calories;
        this.benefits = benefits;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}
