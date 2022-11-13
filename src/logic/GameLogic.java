package logic;

import logic.data.EnumSnackDirection;
import logic.data.GameData;
import model.IDisplay;
import model.InputListener;
import ui.data.EnumInputKey;

import java.awt.*;
import java.util.ArrayList;

/**
 * 游戏逻辑控制器实现
 */
public class GameLogic implements InputListener {

    public static final int WIDTH=30,HEIGHT=30;
    GameData gameData;

    IDisplay display;

    Runnable gameTick= () -> {
        boolean moveResult=GameLogic.this.gameData.getSnake().nextTick(WIDTH,HEIGHT,gameData.getCookiePosition());
    };

    public GameLogic(IDisplay display) {
        gameData=new GameData();
        this.display=display;
        display.setup(this);
    }
    @Override
    public void inputReceived(EnumInputKey key) {
        switch (key){
            case START:
                this.start();
                break;
            case PAUSE_CONTINUE:
                this.pauseContinue();
                break;
            case UP:
                this.gameData.getSnake().turnTo(EnumSnackDirection.NORTH);
                break;
            case DOWN:
                this.gameData.getSnake().turnTo(EnumSnackDirection.SOUTH);
                break;
            case LEFT:
                this.gameData.getSnake().turnTo(EnumSnackDirection.WEST);
                break;
            case RIGHT:
                this.gameData.getSnake().turnTo(EnumSnackDirection.EAST);
                break;
        }
    }

    public void start(){
        //向grids填入所有格子为空白
        this.gameData.grids=new int[WIDTH][HEIGHT];
        for(int i=0;i<HEIGHT;i++){
            for(int j=0;j<WIDTH;j++){
                this.gameData.grids[i][j]=0;
            }
        }
    }
    public void pauseContinue(){

    }

    public boolean nextCookie(){
        return false;
    }
}
