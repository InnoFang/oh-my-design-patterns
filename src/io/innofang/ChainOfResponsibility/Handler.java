package io.innofang.ChainOfResponsibility;

/**
 * Created by Inno Fang on 2017/3/9.
 */
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
