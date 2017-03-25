package io.innofang.TemplateMethod;

/**
 * Created by Inno Fang on 2017/3/23.
 */
public class ComputerAssemblyLine extends AssemblyLine {
    /* 生产铝合金外壳和液晶显示屏 */
    @Override
    protected void onProduceShell() {
        System.out.println("Product Aluminum housing and Liquid Crystal Display");
    }
    /* 生产元器件和键盘 */
    @Override
    protected void onProduceComponents() {
        System.out.println("Product Components and keyboard");
    }
    /* 将产品打包并标上苹果标签 */
    @Override
    protected void onProductPacking() {
        System.out.println("Pack and Mark the Apple trademark");
    }
}
