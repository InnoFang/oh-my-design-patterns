package io.innofang.Builder.base;

/**
 * Created by Inno Fang on 2017/5/5.
 *
 * product
 */
public class Product {

    public String a;
    public String b;
    public String c;

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Product{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}
