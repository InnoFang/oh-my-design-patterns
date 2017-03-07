package io.innofang.State;

/**
 * Created by Inno Fang on 2017/3/7.
 */
public class GameStartState implements GameState {
    /*击杀一只怪物*/
    @Override
    public void killMonster() {
        System.out.println("Kill a Monster");
    }

    /*获得5经验值*/
    @Override
    public void gainExperience() {
        System.out.println("Gain 5 EXP");
    }

    /*进入下一关*/
    @Override
    public void next() {
        System.out.println("Good! please enter next level");
    }

    /*捡到一件好东西*/
    @Override
    public void pick() {
        System.out.println("Wow! You pick a good thing");
    }
}
