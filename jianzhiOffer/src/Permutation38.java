import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * FileName: Permutation38
 * author: gxs
 * Date: 2022/1/12  11:56
 */
public class Permutation38 {
    public String[] permutation(String s) {
        List<String> ans = new LinkedList<>();
        int n = s.length();
        ArrayList<Character> res = new ArrayList<>(n);
        char[] str = s.toCharArray();
        int[] occur = new int[n];
        backtrack(0, n, occur, str, ans, res);
        return (String[]) ans.toArray();
    }
    public void backtrack(int i, int n, int[] occur, char[] str, List<String> ans, ArrayList<Character> res) {
        if (i == n) {
            ans.add(res.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (occur[j] == 1) {
                continue;
            }
            occur[j] = 1;
            res.add(str[j]);
            backtrack(i + 1, n, occur, str, ans, res);
            occur[j] = 0;
            res.remove(str[j]);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Arrays.toString(new Permutation38().permutation(s)));
    }
}
