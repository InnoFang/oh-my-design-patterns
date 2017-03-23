package io.innofang.TemplateMethod;

/**
 * Created by Inno Fang on 2017/3/23.
 */
public class ComputerAssemblyLine extends AssemblyLine {

    @Override
    protected void onProduceShell() {
        System.out.println("Product Aluminum housing and Liquid Crystal Display");
    }

    @Override
    protected void onProduceComponents() {
        System.out.println("Product Components and keyboard");
    }

    @Override
    protected void onProductPacking() {
        System.out.println("Pack and Mark the Apple trademark");
    }
}
