package com.algoblock.Structure.Stack.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;

public class Delete implements StructureMethod {
    private static final String PATTERN = "Stack(@).delete";
    
    @Override 
    public String getPattern() { 
        return PATTERN; 
    }
    
    @Override 
    public void execute(String[] args, RuntimeContext context) {
        String objName = args[0];
        context.removeObject(FakeStack.TYPE_ID, objName);
    }
}