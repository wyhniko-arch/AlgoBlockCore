package com.algoblock.Structure.Stack.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;

public class Push implements StructureMethod {
    private static final String PATTERN = "Stack(@).push";
    @Override public String getPattern() { return PATTERN; }
    @Override public void execute(String[] args, RuntimeContext context) {
        String objName = args[0];
        FakeStack obj = (FakeStack) context.getObject(FakeStack.TYPE_ID, objName);
        if (obj != null) {
            if (!context.isBufferTarget(FakeStack.TYPE_ID, objName)) {
                context.triggerEngineCommand(context.getBufferInstOut()); 
            }
            Integer val = context.popFromBuffer();
            if (val != null) {
                obj.pushVal(val);
            }
        }
    }
}