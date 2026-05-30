package com.algoblock.Structure.Queue.Method;

import com.algoblock.Core;
import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitFull implements StructureMethod {
    private static final String REGEX = "^Queue\\(([a-zA-Z0-9_]+),\\(([\\d,]*)\\)\\)$";

    @Override
    public String getRegex() { return REGEX; }

    @Override
    public void execute(String fullCommand, GameObjectStack stack, Core core) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String objName = m.group(1);
            String values = m.group(2);
            FakeQueue newObj = new FakeQueue();
            newObj.name = objName;
            if (!values.isEmpty()) {
                for (String v : values.split(",")) {
                    newObj.enqueue(Integer.parseInt(v));
                }
            }
            stack.putObject(FakeQueue.TYPE_ID, objName, newObj);
        }
    }
}