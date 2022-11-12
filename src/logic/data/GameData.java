package logic.data;

import java.awt.*;

/**
 * 当前的游戏数据
 */
public class GameData {
    EnumGameStatus gameStatus= EnumGameStatus.READY;
    int score=0;
    Point cookiePosition=new Point(-1,-1);

}
