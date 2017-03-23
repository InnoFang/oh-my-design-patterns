package io.innofang.TemplateMethod;

/**
 * Created by Inno Fang on 2017/3/23.
 */
public class RadioAssemblyLine extends AssemblyLine {

    @Override
    protected void onProduceComponents() {
        System.out.println("Product Radio Components and Antennas");
    }

}
