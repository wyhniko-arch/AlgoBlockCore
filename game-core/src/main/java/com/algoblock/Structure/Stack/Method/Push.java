package com.algoblock.Structure.Stack.Method;

import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Push implements StructureMethod {
    private static final String REGEX = "^Stack\\(([a-zA-Z0-9_]+)\\)\\.push$";
    @Override public String getRegex() { return REGEX; }
    @Override public void execute(String fullCommand, GameObjectStack stack) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String objName = m.group(1);
            FakeStack obj = (FakeStack) stack.getObject(FakeStack.TYPE_ID, objName);
            if (obj != null) {
                if (!stack.isBufferTarget(FakeStack.TYPE_ID, objName)) {
                    stack.triggerEngineCommand(stack.getBufferInstOut()); 
                }
                Integer val = stack.popFromBuffer();
                if (val != null) {
                    obj.pushVal(val);
                }
            }
        }
    }
}