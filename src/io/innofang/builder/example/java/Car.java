package io.innofang.builder.example.java;

/**
 * Created by InnF on 2017/2/19.
 * 产品 —— Car
 */
public class Car {

    private String color;
    private String licensePlate;
    private String brand;

    public void setColor(String color) {
        this.color = color;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
