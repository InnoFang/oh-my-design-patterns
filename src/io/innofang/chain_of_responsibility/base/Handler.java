package io.innofang.chain_of_responsibility.base;

/**
 * Created by Inno Fang on 2017/5/5.
 *
 * Handler
 */
public abstract class Handler {

    protected Handler successor;

    public abstract void handleRequest(String condition);

}
