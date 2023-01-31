package hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * FileName: MyQueue232
 * author: gxs
 * Date: 2022/3/16  9:02
 */
public class MyQueue232 {
    private Deque<Integer> stackIn;
    private Deque<Integer> stackOut;
    private static int pop = 0;
    public MyQueue232() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        pushInToOut();
        int outPop = stackOut.pop();
        pushOutToIn();
        return outPop;
    }

    public int peek() {
        pushInToOut();
        int outPop = stackOut.peek();
        pushOutToIn();
        return outPop;
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void pushInToOut() {
        while (!stackIn.isEmpty()) {
            pop = stackIn.pop();
            stackOut.push(pop);
        }
    }
    private void pushOutToIn() {
        while (!stackOut.isEmpty()) {
            pop = stackOut.pop();
            stackIn.push(pop);
        }
    }
}
