# Chain of Responsibility（责任链模式）

责任链模式作为行为型模式之一，根据"链"这个字，也大概能猜到这是一种链式结构，链式结构具有很好的灵活型，而在
责任链模式中也很好的体现了这一点。在责任链中，若在其中一端发出了请求，那么该请求就会沿着这个"链"
，一直寻找到可以接收并处理的该请求的"结点"，直到找到该结点或者一直到链的另一端结束

## Chain of Responsibility（责任链模式）的UML类图

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/chain_of_responsibility.png)

 + Handler：抽象的请求处理类，
 + ConcreteHandler：具体的请求处理者

如果你学过链表，那么这种结构的模式会很好理解，在抽象的Handler中，会持有一个指向下一个结点的引用successor
当当前结点无法处理发送来的请求的时候，就会将请求直接递给下一个结点

如果非要举个例子的话，那么跟我们生活的最贴近的估计就是下级向上级发请求了

比如，现在实验室需要申请资金用来建设，但是如果申请资金过大，那么这个请求就会一直往上递交，最后的结果要么是获得审批，要么就是被否决

如果是实验室负责人发出请求，那么首先接受到这个请求的就可能是实验室指导老师，然后是学院书记，然后是学院院长，再然后就是学校校长

那么就利用责任链模式，来实现以下这个例子

## 责任链模式的简单实现

先分析一下要求

 + 请求：申请3000元
 + 请求处理者：实验室指导老师（100元及以下），学院书记（1000元及以下），院长（5000元及以下），校长（10000元及以下）

 那么首先是先抽象出一个Handler类
```java
public abstract class Handler {
    /*指向下一个请求处理着*/
    protected Handler successor;
    /*可获批的资金*/
    public abstract int capital();
    /*对申请的资金进行处理*/
    public abstract void handle(int money);
    /*
    因为对于处理的请求判断，逻辑都是一样的，所以应该抽象出来，并且设置为不可覆盖
    处理请求，若能处理就处理，若不能就传递给下一个处理者
     */
    public final void handleRequest(int money) {
        if (money <= capital()) {
            handle(money);
        } else {
            if (null != successor) {
                successor.handleRequest(money);
            } else {
                /*若没有下一个处理者则说明该请求无法传递且无法处理*/
                System.out.println("你的请求的资金无法获批");
            }
        }
    }
}
```

然后，分别构建出：实验室指导老师，学院书记，院长，校长

实验室指导老师
```java
public class Tutor extends Handler {
    @Override
    public int capital() {
        return 100;
    }

    @Override
    public void handle(int money) {
        System.out.println("指导老师审批通过：获批 " + money + "元");
    }
}
```

学院书记
```java
public class Secretary extends Handler{

    @Override
    public int capital() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        System.out.println("书记审批通过：获批 " + money + "元");
    }
}
```

院长
```java
public class Dean extends Handler {
    @Override
    public int capital() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        System.out.println("院长审批通过：获批 " + money + "元");
    }
}
```

校长
```java
public class Principal extends Handler {
    @Override
    public int capital() {
        return 20000;
    }

    @Override
    public void handle(int money) {
        System.out.println("校长审批通过：获批 " + money + "元");
    }
}
```

最后，只需要初始化并构建处理者之间的关系即可
```java
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
```

构建好之后，就可以发送请求了，这里先试试发送2000元的请求试一下
```java
// 发送请求
tutor.handleRequest(2000);
```

结果
```console
院长审批通过：获批 2000元
```

审核通过，那如果审批的是12000元呢？
```java
tutor.handleRequest(12000);
```

结果
```console
你的请求的资金无法获批
```
可以看到，如果请求都无法接受那么这个就会返回一个无法处理的结果

END.