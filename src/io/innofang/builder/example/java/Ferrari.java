package io.innofang.builder.example.java;

/**
 * Created by InnF on 2017/2/19.
 */
public class Ferrari {

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

    public static class Builder{

        Ferrari ferrari;

        public Builder(){
            ferrari = new Ferrari();
        }

        public Builder setColor(String color){
            ferrari.setColor(color);
            return this;
        }

        public Builder setLicensePlate(String licensePlate) {
            ferrari.setLicensePlate(licensePlate);
            return this;
        }

        public Builder setBrand(String brand){
            ferrari.setBrand(brand);
            return this;
        }

        public Ferrari build(){
            return ferrari;
        }

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
