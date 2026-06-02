package com.algoblock.Structure.Stack.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;

public class InitEmpty implements StructureMethod {
    private static final String PATTERN = "Stack(@)";
    
    @Override 
    public String getPattern() { 
        return PATTERN; 
    }
    
    @Override 
    public void execute(String[] args, RuntimeContext context) {
        String objName = args[0];
        FakeStack newObj = new FakeStack();
        newObj.name = objName; // 分配栈对象名称
        context.putObject(FakeStack.TYPE_ID, newObj.name, newObj);
    
    }
}