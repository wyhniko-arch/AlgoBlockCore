package com.algoblock.Structure.Stack.Method;

import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Stack.FakeStack;
import com.algoblock.Structure.StructureMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitFull implements StructureMethod {
    private static final String REGEX = "^Stack\\(([a-zA-Z0-9_]+),\\(([\\d,]*)\\)\\)$";
    @Override public String getRegex() { return REGEX; }
    @Override public void execute(String fullCommand, GameObjectStack stack) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String objName = m.group(1);
            String values = m.group(2);
            FakeStack newObj = new FakeStack();
            newObj.name = objName;
            if (!values.isEmpty()) {
                // 字符串解析，依次压栈（底层对应栈底，最新压入的对应栈顶）
                for (String v : values.split(",")) {
                    newObj.pushVal(Integer.parseInt(v));
                }
            }
            stack.putObject(FakeStack.TYPE_ID, objName, newObj);
        }
    }
}