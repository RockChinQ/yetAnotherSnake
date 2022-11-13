package logic.data;

import java.awt.*;

/**
 * 当前的游戏数据
 */
public class GameData {
    //游戏状态
    EnumGameStatus gameStatus= EnumGameStatus.READY;
    //分数
    int score=0;
    //食物坐标
    Point cookiePosition=new Point(-1,-1);
    //蛇对象
    Snake snake=new Snake();

    public int[][] grids;

    public EnumGameStatus getGameStatus() {
        return gameStatus;
    }

    public int getScore() {
        return score;
    }

    public Point getCookiePosition() {
        return cookiePosition;
    }

    public Snake getSnake() {
        return snake;
    }

    public int[][] getGrids(){
        return grids;
    }
}
