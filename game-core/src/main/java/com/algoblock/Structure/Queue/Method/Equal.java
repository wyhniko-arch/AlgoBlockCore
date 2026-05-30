package com.algoblock.Structure.Queue.Method;

import com.algoblock.Core;
import com.algoblock.GameObjectStack;
import com.algoblock.Structure.Queue.FakeQueue;
import com.algoblock.Structure.StructureMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Equal implements StructureMethod {
    private static final String REGEX = "^Queue\\.equal\\(([a-zA-Z0-9_]+),([a-zA-Z0-9_]+)\\)$";

    @Override
    public String getRegex() { return REGEX; }

    @Override
    public void execute(String fullCommand, GameObjectStack stack, Core core) {
        Matcher m = Pattern.compile(REGEX).matcher(fullCommand);
        if (m.matches()) {
            String nameA = m.group(1);
            String nameB = m.group(2);
            FakeQueue objA = (FakeQueue) stack.getObject(FakeQueue.TYPE_ID, nameA);
            FakeQueue objB = (FakeQueue) stack.getObject(FakeQueue.TYPE_ID, nameB);
            
            // 执行范式6：无论结果如何，必须增加一次判断总数
            stack.incrementRunCheck();
            if (objA != null && objB != null && objA.size == objB.size) {
                boolean isEqual = true;
                // 按队列顺序逐个对比环形数组元素
                for (int i = 0; i < objA.size; i++) {
                    int indexA = (objA.head + i) % objA.array.length;
                    int indexB = (objB.head + i) % objB.array.length;
                    if (objA.array[indexA] != objB.array[indexB]) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    stack.incrementPassedCheck();
                }
            }
        }
    }
}