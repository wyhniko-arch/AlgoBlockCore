package com.algoblock.Structure.Queue.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

public class Pop implements StructureMethod {
    private static final String PATTERN = "Queue(@).pop";

    @Override
    public String getPattern() { return PATTERN; }

    @Override
    public void execute(String[] args, RuntimeContext context) {
        String objName = args[0];
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