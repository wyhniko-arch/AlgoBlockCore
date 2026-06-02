package com.algoblock.Structure.Queue.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

public class InitEmpty implements StructureMethod {
    private static final String PATTERN = "Queue(@)";

    @Override
    public String getPattern() { return PATTERN; }

    @Override
    public void execute(String[] args, RuntimeContext context) {
        String objName = args[0];
        FakeQueue newObj = new FakeQueue();
        newObj.name = objName;
        context.putObject(FakeQueue.TYPE_ID, objName, newObj);
    }
}