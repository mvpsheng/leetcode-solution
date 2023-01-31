import java.util.Stack;

/**
 * FileName: ValidateStackSequences31
 * author: gxs
 * Date: 2022/1/11  16:47
 */
public class ValidateStackSequences31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean possible = false;
        int m = pushed.length;
        int n = popped.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (j != n){
            if (i < m && (stack.empty() || stack.peek() != popped[j])) {
                stack.push(pushed[i++]);
            }
            if (i == m && stack.peek() != popped[j]) break;
            if (stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            possible = true;
        }
        return possible;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,5,3,2,1};
        System.out.println(new ValidateStackSequences31().validateStackSequences(pushed, poped));
    }
}
