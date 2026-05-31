package com.algoblock.Structure.Queue.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pop implements StructureMethod {
    private static final String REGEX = "^Queue\\(([a-zA-Z0-9_]+)\\)\\.pop$";

    @Override
    public String getRegex() { return REGEX; }

    @Override
    public void execute(String fullCommand, RuntimeContext context) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String objName = m.group(1);
            FakeQueue obj = (FakeQueue) context.getObject(FakeQueue.TYPE_ID, objName);
            if (obj != null) {
                if (obj.size > 0) {
                    context.pushToBuffer(obj.dequeue());
                }
                if (!context.isBufferTarget(FakeQueue.TYPE_ID, objName)) {
                    context.triggerEngineCommand(context.getBufferInstIn());
                }
            }
        }
    }
}