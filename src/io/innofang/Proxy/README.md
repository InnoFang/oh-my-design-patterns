# Proxy（代理）

代理模式一种十分常用的模式。日常生活中，我们也经常使用代理，比如有时候你会叫你的朋友代取快递等

总之，代理模式就是将一些自己不想或无法处理的事，交给代理者去做。

## Proxy（代理）的UML类图
![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/proxy.png)

 + Subject : 代理者和被代理者的共同主题
 + ProxySubject : 代理类
 + RealSubject  : 被代理类或者叫真实类
 + Client : 代理类使用者

 之所以需要代理类和被代理类都实现统一的接口，是为了保证客户类的透明性，在使用代理类时可以执行被代理类的操作

## 代理模式的简单实现

刚才例举了叫朋友带去快递的例子，那么现在就以这个案例为原型，来实现以下代理模式

为了更好的体现代理模式的优势，这里将整个取快递的流程分为：

 1. 接收快递短信通知
 2. 取快递
 3. 签字验收三个步骤

那么首先实现抽象主题类

IPicker
```java
public interface IPicker {
    /*接收快递短信通知*/
    void receiveMessage();
    /*取快递*/
    void takeCourier();
    /*签字验收三个步骤*/
    void signatureAcceptance();
}
```

具体的取快递的人
```java
public class RealPicker implements IPicker {
    @Override
    public void receiveMessage() {
        System.out.println("Receive text message");
    }

    @Override
    public void takeCourier() {
        System.out.println("Take the courier");
    }

    @Override
    public void signatureAcceptance() {
        System.out.println("Signature Acceptance");
    }
}
```

代理去快递的人
```java
public class ProxyPicker implements IPicker {

    private IPicker picker;

    public ProxyPicker(IPicker picker) {
        this.picker = picker;
    }

    @Override
    public void receiveMessage() {
        picker.receiveMessage();
    }

    @Override
    public void takeCourier() {
        picker.takeCourier();
    }

    @Override
    public void signatureAcceptance() {
        picker.signatureAcceptance();
    }
}
```

OK, 下面就可以叫自己的代理者去取快递了
```java
IPicker picker = new RealPicker();
ProxyPicker proxyPicker = new ProxyPicker(picker);

proxyPicker.receiveMessage();
proxyPicker.takeCourier();
proxyPicker.signatureAcceptance();
```

执行结果如下:
```console
Receive text message
Take the courier
Signature Acceptance
```


END.