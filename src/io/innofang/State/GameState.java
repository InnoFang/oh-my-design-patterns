package io.innofang.State;


public interface GameState {
    public void killMonster();

    public void gainExperience();

    public void next();

    public void pick();
}
