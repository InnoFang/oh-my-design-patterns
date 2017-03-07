package io.innofang.State;

/**
 * Created by Inno Fang on 2017/3/7.
 */
public class Client {
    GameState state;

    public void setState(GameState state) {
        this.state = state;
    }

    public void gameStart() {
        setState(new GameStartState());
        System.out.println("\n-----Game Start, ready to fight-----\n");
    }

    public void gameOver(){
        setState(new GameOverState());
        System.out.println("\n-----         Game Over        -----\n");
    }

    public void killMonster(){
        state.killMonster();
    }

    public void gainExperience() {
        state.gainExperience();
    }

    public void next(){
        state.next();
    }

    public void pick(){
        state.pick();
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.gameStart();
        client.killMonster();
        client.gainExperience();
        client.next();
        client.pick();
        client.gameOver();
        client.next();
        client.killMonster();
        client.pick();
    }
}
