package com.algoblock.Structure.Stack.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Push implements StructureMethod {
    private static final String REGEX = "^Stack\\(([a-zA-Z0-9_]+)\\)\\.push$";
    @Override public String getRegex() { return REGEX; }
    @Override public void execute(String fullCommand, RuntimeContext context) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String objName = m.group(1);
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
}