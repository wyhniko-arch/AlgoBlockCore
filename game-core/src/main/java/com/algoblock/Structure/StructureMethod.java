package com.algoblock.Structure;

import com.algoblock.GameObjectStack;

public interface StructureMethod {
    /**
     * 获取当前指令关联的正则表达式
     */
    String getRegex();

    /**
     * 规范化的执行接口
     * @param fullCommand 完整正则匹配的字符串
     * @param stack       游戏对象栈引用
     * @param core        引擎Core引用，用于回调Buffer指令
     */
    void execute(String fullCommand, GameObjectStack stack);
}