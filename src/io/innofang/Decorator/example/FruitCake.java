package io.innofang.Decorator.example;

/**
 * Created by Inno Fang on 2017/5/4.
 */
public class FruitCake extends DecorateCake {

    public FruitCake(Cake cake) {
        super(cake);
    }

    @Override
    public void make() {
        addSomeFruit();
        super.make();
    }

    private void addSomeFruit() {
        System.out.println("Add some fruit");
    }
}
