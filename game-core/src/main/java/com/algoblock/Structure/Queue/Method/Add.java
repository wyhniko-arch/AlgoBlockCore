package com.algoblock.Structure.Queue.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

public class Add implements StructureMethod {
    private static final String PATTERN = "Queue(@).add";

    @Override
    public String getPattern() { return PATTERN; }

    @Override
    public void execute(String[] args, RuntimeContext context) {
        // args[0] 对应模板中唯一的一个 @
        String objName = args[0];
        FakeQueue obj = (FakeQueue) context.getObject(FakeQueue.TYPE_ID, objName);
        if (obj != null) {
            if (!context.isBufferTarget(FakeQueue.TYPE_ID, objName)) {
                context.triggerEngineCommand(context.getBufferInstOut()); 
            }
            Integer val = context.popFromBuffer();
            if (val != null) {
                obj.enqueue(val);
            }
        }
    }
}