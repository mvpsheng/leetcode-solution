/**
 * FileName: PrintNumbers17
 * author: gxs
 * Date: 2022/1/7  16:44
 */
public class PrintNumbers17 {

    //        解法二：
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
//        解法一：
//        int end = (int) (Math.pow(10, n) - 1);
//        int[] res = new int[end];
//        for (int i = 0; i < end; i++) {
//            res[i] = i + 1;
//        }
//        return res;
//解法二：
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0"))
                res[count++] = Integer.parseInt(s);
            if (n - start == nine)
                start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        int[] ans = new PrintNumbers17().printNumbers(3);
        for (int i = 0; i < ans.length; i++) {
            if (i % 20 == 0) {
                System.out.println();
            }
            System.out.print(" " + ans[i]);
        }
    }
}
