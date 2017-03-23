package io.innofang.TemplateMethod;

/**
 * Created by Inno Fang on 2017/3/23.
 */
public class Test {

    public static void main(String[] args) {
        AssemblyLine assemblyLine = new RadioAssemblyLine();
        assemblyLine.product();

        System.out.println();

        assemblyLine = new ComputerAssemblyLine();
        assemblyLine.product();
    }

}
