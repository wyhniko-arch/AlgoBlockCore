package com.algoblock.Structure.Stack.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;

public class Pop implements StructureMethod {
    private static final String PATTERN = "Stack(@).pop";
    @Override public String getPattern() { return PATTERN; }
    @Override public void execute(String[] args, RuntimeContext context) {
        String objName = args[0];
        FakeStack obj = (FakeStack) context.getObject(FakeStack.TYPE_ID, objName);
        if (obj != null) {
            if (obj.top >= 0) {
                context.pushToBuffer(obj.popVal());
            }
            if (!context.isBufferTarget(FakeStack.TYPE_ID, objName)) {
                context.triggerEngineCommand(context.getBufferInstIn()); 
            }
        }
    }
}