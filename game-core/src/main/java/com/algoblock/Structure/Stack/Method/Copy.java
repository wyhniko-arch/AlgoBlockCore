package com.algoblock.Structure.Stack.Method;

import com.algoblock.Core;
import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Copy implements StructureMethod {
    private static final String REGEX = "^Stack\\(([a-zA-Z0-9_]+)\\)\\.copy\\(([a-zA-Z0-9_]+)\\)$";
    @Override public String getRegex() { return REGEX; }
    @Override public void execute(String fullCommand, GameObjectStack stack, Core core) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            FakeStack srcObj = (FakeStack) stack.getObject(FakeStack.TYPE_ID, m.group(1));
            if (srcObj != null) {
                FakeStack newObj = new FakeStack();
                newObj.name = m.group(2);
                newObj.array = new int[srcObj.array.length];
                System.arraycopy(srcObj.array, 0, newObj.array, 0, srcObj.array.length);
                newObj.top = srcObj.top;
                stack.putObject(FakeStack.TYPE_ID, newObj.name, newObj);
            }
        }
    }
}