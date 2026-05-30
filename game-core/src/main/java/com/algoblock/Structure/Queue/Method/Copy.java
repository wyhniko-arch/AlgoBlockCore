package com.algoblock.Structure.Queue.Method;

import com.algoblock.Core;
import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Copy implements StructureMethod {
    private static final String REGEX = "^Queue\\(([a-zA-Z0-9_]+)\\)\\.copy\\(([a-zA-Z0-9_]+)\\)$";

    @Override
    public String getRegex() { return REGEX; }

    @Override
    public void execute(String fullCommand, GameObjectStack stack, Core core) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String srcName = m.group(1);
            String destName = m.group(2);
            FakeQueue srcObj = (FakeQueue) stack.getObject(FakeQueue.TYPE_ID, srcName);
            if (srcObj != null) {
                FakeQueue newObj = new FakeQueue();
                newObj.name = destName;
                newObj.array = new int[srcObj.array.length];
                System.arraycopy(srcObj.array, 0, newObj.array, 0, srcObj.array.length);
                newObj.head = srcObj.head;
                newObj.tail = srcObj.tail;
                newObj.size = srcObj.size;
                stack.putObject(FakeQueue.TYPE_ID, destName, newObj);
            }
        }
    }
}