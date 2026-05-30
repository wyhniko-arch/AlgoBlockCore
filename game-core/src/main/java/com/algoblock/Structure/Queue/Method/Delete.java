package com.algoblock.Structure.Queue.Method;

import com.algoblock.Core;
import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delete implements StructureMethod {
    private static final String REGEX = "^Queue\\(([a-zA-Z0-9_]+)\\)\\.delete$";

    @Override
    public String getRegex() { return REGEX; }

    @Override
    public void execute(String fullCommand, GameObjectStack stack, Core core) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String objName = m.group(1);
            stack.removeObject(FakeQueue.TYPE_ID, objName);
        }
    }
}