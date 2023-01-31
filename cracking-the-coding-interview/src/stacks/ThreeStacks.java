package stacks;

import java.util.EmptyStackException;

/**
 * FileName: ThreeStacks
 * author: gxs
 * Date: 2022/1/19  15:38
 */
//Describe how you could use a single array
// to implement three stacks

public class ThreeStacks {
    int stackSize = 100;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointer = {-1, -1, -1};

    void push(int stackNum, int value) throws Exception {
        /* check if we have space */
        if (stackPointer[stackNum] + 1 >= stackSize) {
            throw new Exception();
        }
        /* increment stack pointer and then update top value */
        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int value = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        stackPointer[stackNum]--;
        return value;
    }

    int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int index = absTopOfStack(stackNum);
        return buffer[index];
    }

    boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    /* returns index of top of stack "stackNum", in absolute terms */
    int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}
