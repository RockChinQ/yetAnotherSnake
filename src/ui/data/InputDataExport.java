package ui.data;

import java.util.ArrayList;

/**
 * 传递UI收到的输入数据
 */
@Deprecated
public class InputDataExport {
    private ArrayList<EnumInputKey> inputKeys=new ArrayList<>();

    /**
     * 存入一个输入键
     * @param key
     */
    public void pushKey(EnumInputKey key){
        inputKeys.add(key);
    }

    public ArrayList<EnumInputKey> getInputKeys() {
        return inputKeys;
    }
}
