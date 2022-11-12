package logic.data;

/**
 * 游戏状态
 */
public enum EnumGameStatus {
    /*游戏初始化完毕，启动后是此状态*/
    READY,
    /*游戏结束*/
    STOPPED,
    /*正在进行中*/
    PLAYING,
    /*游戏暂停*/
    PAUSED,
}
