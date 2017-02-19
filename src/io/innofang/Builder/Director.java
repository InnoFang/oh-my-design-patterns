package io.innofang.Builder;

/**
 * Created by InnF on 2017/2/19.
 * 组装产品
 */
public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(String color, String licensePlate, String brand) {
        builder.buildColor(color);
        builder.buildLicensePlate(licensePlate);
        builder.buildBrand(brand);
    }
}
