package com.algoblock.Structure;

import com.algoblock.GameObjectStack;
import com.algoblock.Core;
import java.util.Map;

public abstract class Abstract {
    public String name; // 修改为public或protected，以便具体的Method类访问
    
    public Abstract() {}

    /**
     * 获取当前结构已加载的所有指令的正则表达式映射
     * @return 映射表 (Instruction ID -> Regex)
     */
    public abstract Map<String, String> getRegexPatterns();

    /**
     * 结构端分发器：将执行指令路由给具体的动态方法类
     */
    public abstract void executeInstruction(String instId, String fullCommand, GameObjectStack stack, Core core);

    /**
     * [规范化核心机制]：当Core发现配置允许某个指令，但结构尚未加载该指令时，调用此方法进行反射动态加载
     * @param instId 需要加载的指令ID
     * @return 是否成功加载
     */
    public abstract boolean loadMethodDynamically(String instId);
}