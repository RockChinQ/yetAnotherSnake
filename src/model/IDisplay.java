package model;

import logic.data.GameData;

/**
 * 游戏显示器接口
 */
public interface IDisplay {
    /**
     * 向显示器注册输入监听器
     * @param inputListener
     */
    void setup(InputListener inputListener);

    /**
     * 使用游戏数据打包对象更新一次界面
     * @param gameDataExport
     */
    void update(GameData gameDataExport);
}
