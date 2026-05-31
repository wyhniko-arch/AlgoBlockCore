package com.algoblock.Structure.Queue.Method;

import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Add implements StructureMethod {
    private static final String REGEX = "^Queue\\(([a-zA-Z0-9_]+)\\)\\.add$";

    @Override
    public String getRegex() { return REGEX; }

    @Override
    public void execute(String fullCommand, GameObjectStack stack) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String objName = m.group(1);
            FakeQueue obj = (FakeQueue) stack.getObject(FakeQueue.TYPE_ID, objName);
            if (obj != null) {
                if (!stack.isBufferTarget(FakeQueue.TYPE_ID, objName)) {
                    stack.triggerEngineCommand(stack.getBufferInstOut()); 
                }
                Integer val = stack.popFromBuffer();
                if (val != null) {
                    obj.enqueue(val);
                }
            }
        }
    }
}