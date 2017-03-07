package io.innofang.State;


public interface GameState {
    /*打怪*/
    public void killMonster();
    /*获得经验*/
    public void gainExperience();
    /*进入下一关*/
    public void next();
    /*捡拾物品*/
    public void pick();
}
