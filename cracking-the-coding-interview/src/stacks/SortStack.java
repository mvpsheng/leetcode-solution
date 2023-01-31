package stacks;

import jdk.dynalink.beans.StaticClass;

import java.util.Stack;

/**
 * FileName: SortStack
 * author: gxs
 * Date: 2022/1/19  15:19
 */
/* write a program to sort a stack in ascending order (with biggest items on top).
 * you may use at most one additional stack to hold items, but you may not copy the
 * elements into any other data strcuture (such as an array). The stack supports the
 * folowing operations: push, pop, peek, and isEmpty */
public class SortStack {
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(1);
        stack1.push(6);
        stack1.push(3);
        stack1.push(2);
        stack1.push(5);
        stack2 = sort(stack1);
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }
}
