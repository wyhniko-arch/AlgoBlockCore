package com.algoblock.Structure.Stack.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitEmpty implements StructureMethod {
    private static final String REGEX = "^Stack\\(([a-zA-Z0-9_]+)\\)$";
    
    @Override 
    public String getRegex() { 
        return REGEX; 
    }
    
    @Override 
    public void execute(String fullCommand, RuntimeContext context) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            FakeStack newObj = new FakeStack();
            newObj.name = m.group(1); // 分配栈对象名称
            context.putObject(FakeStack.TYPE_ID, newObj.name, newObj);
        }
    }
}