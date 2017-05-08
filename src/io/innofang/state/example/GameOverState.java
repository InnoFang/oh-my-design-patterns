package io.innofang.state.example;

/**
 * Created by Inno Fang on 2017/3/7.
 */
public class GameOverState implements GameState {
    /*游戏没开始，无法打怪*/
    @Override
    public void killMonster() {
        System.out.println("Please start game first");
    }
    /*游戏没开始，无法获得经验*/
    @Override
    public void gainExperience() {

    }
    /*游戏已经结束，下一步就是选择是否重新开始*/
    @Override
    public void next() {
        System.out.println("You want to challenge again?");
    }
    /*游戏没开始，无好东西可以捡*/
    @Override
    public void pick() {
        System.out.println("Please start game first");
    }
}
