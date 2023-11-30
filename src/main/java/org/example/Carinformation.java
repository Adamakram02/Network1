package org.example;

public class Carinformation {

    private String make;
    private String model;
    private String year;
    private String color;
    private String oName;
    private String oID;

    public Carinformation(String make, String model, String year, String color, String oName, String oID) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.oName = oName;
        this.oID = oID;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getoName() {
        return oName;
    }
    public void setoName(String oName) {
        this.oName = oName;
    }
    public String getoID() {
        return oID;
    }
    public void setoID(String oID) {
        this.oID = oID;
    }
    @Override
    public String toString() {
        return  make + "  |  " + model + "  |  " + year + "  |  " + color + "  |     " + oName + "     |  " + oID+"   |";
    }
}

