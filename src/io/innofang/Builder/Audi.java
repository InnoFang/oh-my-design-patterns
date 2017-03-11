package io.innofang.Builder;

/**
 * Created by Inno Fang on 2017/3/11.
 */
public class Audi {

    private String color;
    private String licensePlate;
    private String brand;

    public static class Builder {

        private String color;
        private String licensePlate;
        private String brand;

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Audi build(){
            return new Audi(this);
        }
    }

    private Audi(Builder builder) {
        color = builder.color;
        licensePlate = builder.licensePlate;
        brand = builder.brand;
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
