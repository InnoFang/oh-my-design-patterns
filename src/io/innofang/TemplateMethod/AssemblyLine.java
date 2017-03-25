package io.innofang.TemplateMethod;

/**
 * Created by Inno Fang on 2017/3/23.
 */
public abstract class AssemblyLine {
    /* 生产产品外壳 */
    protected void onProduceShell() {
        System.out.println("Produce Shell");
    }
    /* 生产元器件 */
    protected void onProduceComponents() {
        System.out.println("Produce some components");
    }
    /* 元器件装配 */
    protected void onAssemblyComponents() {
        System.out.println("Assembly Components");
    }
    /* 产品测试 */
    protected void onTestProducts(){
        System.out.println("Test Products");
    }
    /* 产品装箱 */
    protected void onProductPacking() {
        System.out.println("Product Packing");
    }
    /* 流水线产品制作流程封装 */
    public final void product() {
        System.out.println("+------Start Product------+");
        onProduceShell();
        onProduceComponents();
        onAssemblyComponents();
        onTestProducts();
        onProduceComponents();
        onProductPacking();
        System.out.println("+------Finish Product------+");
    }
}
