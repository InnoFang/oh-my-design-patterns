package io.innofang.Decorator.example;

/**
 * Created by Inno Fang on 2017/5/4.
 */
public class ChocolateCake extends DecorateCake {

    public ChocolateCake(Cake cake) {
        super(cake);
    }

    @Override
    public void make() {
        addChocolate();
        super.make();

    }

    private void addChocolate() {
        System.out.println("Add Chocolate");
    }
}
