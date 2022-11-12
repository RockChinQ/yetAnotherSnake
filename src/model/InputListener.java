package model;

import ui.data.EnumInputKey;
import ui.data.InputDataExport;

/**
 * 显示器
 */
public interface InputListener {
    /**
     * 获得一个输入
     * @param key
     */
    void inputReceived(EnumInputKey key);
}
