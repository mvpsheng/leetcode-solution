package xiecheng;

import java.util.LinkedList;

/**
 * FileName: StringStructrue
 * author: gxs
 * Date: 2021/9/30  19:54
 */
public class StringStructrue {
    private LinkedList<String> buildStr(int n,int[][] nums) {
        boolean changed = true;
        LinkedList<String> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (changed) {
                    changed =false;
                    for (int j = 0; j < 26; j++) {
                    if (nums[i][j] > 0) {
                        nums[i][j]--;
                        changed = true;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((1 + 'A'));
    }
}
