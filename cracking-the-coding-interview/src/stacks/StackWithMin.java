package stacks;

import java.util.Stack;

/**
 * FileName: StackWithMin
 * author: gxs
 * Date: 2022/1/19  15:32
 */
//How would you design a stack which,
// in addition to push and pop,
// also has a function min which returns the minimum element?
// Push, pop, and min should all operate in O(1) time
class NodeWithMin {
    public int value;
    public int min;
    public NodeWithMin(int v, int min) {
        this.value = v;
        this.min = min;
    }
}
public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }
    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}

