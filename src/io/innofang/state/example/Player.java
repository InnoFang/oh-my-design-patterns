package io.innofang.state.example;

/**
 * Created by Inno Fang on 2017/3/7.
 */
public class Player {
    /*游戏状态*/
    GameState state;
    /*游戏状态的设置*/
    public void setState(GameState state) {
        this.state = state;
    }
    /*游戏开始*/
    public void gameStart() {
        setState(new GameStartState());
        System.out.println("\n-----Game Start, ready to fight-----\n");
    }
    /*游戏结束*/
    public void gameOver(){
        setState(new GameOverState());
        System.out.println("\n-----         Game Over        -----\n");
    }
    /*打怪*/
    public void killMonster(){
        state.killMonster();
    }
    /*获得经验*/
    public void gainExperience() {
        state.gainExperience();
    }
    /*下一关*/
    public void next(){
        state.next();
    }
    /*捡东西*/
    public void pick(){
        state.pick();
    }

    public static void main(String[] args) {
        /*游戏开始后的一系列操作和结束后的操作*/
        Player player = new Player();
        player.gameStart();
        player.killMonster();
        player.gainExperience();
        player.next();
        player.pick();
        player.gameOver();
        player.next();
        player.killMonster();
        player.pick();
    }
}
