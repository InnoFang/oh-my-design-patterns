package io.innofang.builder.example.java;

/**
 * Created by InnF on 2017/2/19.
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new CarBuilder();
        Director director =new Director(builder);
        director.construct("red", "A88888", "Ferrari");
        System.out.println(builder.build().toString());

        // Call Chaining
        Ferrari ferrari = new Ferrari.Builder()
                .setBrand("Ferrari")
                .setColor("Red")
                .setLicensePlate("B88888")
                .build();
        System.out.println(ferrari.toString());

        // Call Chaining 2
        Audi audi = new Audi.Builder()
                .setBrand("Audi")
                .setColor("Blue")
                .setLicensePlate("C88888")
                .build();
        System.out.println(audi.toString());
    }
}
