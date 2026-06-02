package com.algoblock.Structure.Queue.Method;

import com.algoblock.RuntimeContext;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

public class InitFull implements StructureMethod {
    private static final String PATTERN = "Queue(@,(@))";

    @Override
    public String getPattern() { return PATTERN; }

    @Override
    public void execute(String[] args, RuntimeContext context) {
   
        String objName =args[0];
        String values = args[1];
        FakeQueue newObj = new FakeQueue();
        newObj.name = objName;
        if (!values.isEmpty()) {
            for (String v : values.split(",")) {
                newObj.enqueue(Integer.parseInt(v));
            }
        }
        context.putObject(FakeQueue.TYPE_ID, objName, newObj);
    
    }
}