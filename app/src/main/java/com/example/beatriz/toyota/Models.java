package com.example.beatriz.toyota;

public class Models {
    public String name;
    public String power;
    public String fuel;
    public String price;

    public Models() {

    }

    public Models(String name, String power, String fuel, String price) {
        this.name = name;
        this.power = power;
        this.fuel = fuel;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
