package com.algoblock.Structure.Stack.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delete implements StructureMethod {
    private static final String REGEX = "^Stack\\(([a-zA-Z0-9_]+)\\)\\.delete$";
    
    @Override 
    public String getRegex() { 
        return REGEX; 
    }
    
    @Override 
    public void execute(String fullCommand, RuntimeContext context) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            // 从游戏对象栈中释放指定的Stack对象
            context.removeObject(FakeStack.TYPE_ID, m.group(1));
        }
    }
}