import java.util.Stack;

/**
 * FileName: MinStack30
 * author: gxs
 * Date: 2022/1/11  16:40
 */
public class MinStack30 {
    Stack<Integer> A, B;
    public MinStack30() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
