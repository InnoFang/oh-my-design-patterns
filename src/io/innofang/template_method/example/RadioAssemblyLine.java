package io.innofang.template_method.example;

/**
 * Created by Inno Fang on 2017/3/23.
 */
public class RadioAssemblyLine extends AssemblyLine {
    /* 生产收音机元器件和天线 */
    @Override
    protected void onProduceComponents() {
        System.out.println("Product Radio Components and Antennas");
    }
}
