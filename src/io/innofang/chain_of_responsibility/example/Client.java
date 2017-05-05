package io.innofang.chain_of_responsibility.example;

/**
 * Created by Inno Fang on 2017/3/9.
 */
public class Client {

    public static void main(String[] args) {
        // 初始化各个处理者
        Tutor tutor = new Tutor();
        Secretary secretary = new Secretary();
        Dean dean = new Dean();
        Principal principal = new Principal();

        // 让各个处理者之间形成链式关系
        tutor.successor = secretary;
        secretary.successor = dean;
        dean.successor = principal;
        principal.successor = null;

        // 发送请求
//        tutor.handleRequest(2000);
        tutor.handleRequest(12000);
    }
}
