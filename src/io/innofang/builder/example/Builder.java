package io.innofang.builder.example;

/**
 * Created by InnF on 2017/2/19.
 * Builder接口
 * 以构建一辆车为例
 */
public interface Builder {

    // 构建车的颜色
    void buildColor(String color);

    // 构建车的车牌
    void buildLicensePlate(String licensePlate);

    // 构建车的商标
    void buildBrand(String brand);

    // 构建完成最终的汽车
    Car build();
}
