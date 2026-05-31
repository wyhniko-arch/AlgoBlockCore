package com.algoblock.Structure.Stack.Method;

import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Equal implements StructureMethod {
    private static final String REGEX = "^Stack\\.equal\\(([a-zA-Z0-9_]+),([a-zA-Z0-9_]+)\\)$";
    @Override public String getRegex() { return REGEX; }
    @Override public void execute(String fullCommand, GameObjectStack stack) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            FakeStack objA = (FakeStack) stack.getObject(FakeStack.TYPE_ID, m.group(1));
            FakeStack objB = (FakeStack) stack.getObject(FakeStack.TYPE_ID, m.group(2));
            
            stack.incrementRunCheck();
            if (objA != null && objB != null && objA.top == objB.top) {
                boolean isEqual = true;
                // 线性数组比对，直到栈顶
                for (int i = 0; i <= objA.top; i++) {
                    if (objA.array[i] != objB.array[i]) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) stack.incrementPassedCheck();
            }
        }
    }
}