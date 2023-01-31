package stacks;

import java.util.Stack;

/**
 * FileName: MyQueue
 * author: gxs
 * Date: 2022/1/19  14:59
 */
/* implement a MyQueue class which implements a queue using two stacks */
public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        this.stackNewest = new Stack<T>();
        this.stackOldest = new Stack<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        /* push onto stackNewest, which always has the newest
         * elements on top */
        stackNewest.push(value);
    }

    /* Move elements from stackNewest into stackOldest. This
     * is usually done so that we can do operations on stackOldest */
    public void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
}
