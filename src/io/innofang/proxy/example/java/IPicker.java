package io.innofang.proxy.example.java;

/**
 * Created by Inno Fang on 2017/4/8.
 * 取快递
 */
public interface IPicker {
    /*接收快递短信通知*/
    void receiveMessage();
    /*取快递*/
    void takeCourier();
    /*签字验收三个步骤*/
    void signatureAcceptance();
}
