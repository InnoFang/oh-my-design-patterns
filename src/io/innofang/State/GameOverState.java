package io.innofang.State;

/**
 * Created by Inno Fang on 2017/3/7.
 */
public class GameOverState implements GameState {
    @Override
    public void killMonster() {
        System.out.println("Please start game first");
    }

    @Override
    public void gainExperience() {

    }

    @Override
    public void next() {
        System.out.println("You want to challenge again?");
    }

    @Override
    public void pick() {
        System.out.println("Please start game first");
    }

}
