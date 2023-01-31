/**
 * FileName: SpiralOrder29
 * author: gxs
 * Date: 2022/1/10  17:26
 */
public class SpiralOrder29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0,
                b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
//            从左到右
            for (int i = 1; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) break;
//            从上到下
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (l > --r) break;
//            从右到左
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (t > --b) break;
//            从下向上
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return res;
    }
}
