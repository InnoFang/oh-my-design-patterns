package io.innofang.Builder.example;

/**
 * Created by InnF on 2017/2/19.
 */
public class CarBuilder implements Builder {

    Car car;

    public CarBuilder(){
        car = new Car();
    }

    @Override
    public void buildColor(String color) {
        car.setColor(color);
    }

    @Override
    public void buildLicensePlate(String licensePlate) {
        car.setLicensePlate(licensePlate);
    }

    @Override
    public void buildBrand(String brand) {
        car.setBrand(brand);
    }

    @Override
    public Car build() {
        return car;
    }
}
