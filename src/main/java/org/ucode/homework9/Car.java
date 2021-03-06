package org.ucode.homework9;

public class Car {
    private String make;
    private String model;
    private String fuelType;
    private int carID;
    private int rentalPrice;
    private int year;
    private int mileage;


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

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Car(int carID, String make, String model,int rentalPrice, int year, int mileage, String fuelType) {
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.carID = carID;
        this.rentalPrice = rentalPrice;
        this.year = year;
        this.mileage = mileage;
    }
}