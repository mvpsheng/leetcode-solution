package stacks;

import java.util.ArrayList;
import java.util.Stack;

/**
 * FileName: SetOfStacks
 * author: gxs
 * Date: 2022/1/19  15:05
 */
/* imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack
 * exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should
 * behave identically to a single stack (that is, pop() should return the same values as
 * it would if there were just a single stack) */
//in this problem, we've been told what our data structure should look like:
public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<>();
    int capacity = 10;

    public void push(int v) {
        Stack last = getLastStack();
        if (last != null) {
            last.push(v);
        } else {
            Stack stack = new Stack();
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        int v = (int) last.pop();
        if (last.size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    public Stack getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }
}
