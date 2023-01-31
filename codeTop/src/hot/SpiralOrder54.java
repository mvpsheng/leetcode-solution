package hot;

import java.util.LinkedList;
import java.util.List;

/**
 * FileName: SpiralOrder54
 * author: gxs
 * Date: 2021/10/9  22:53
 */
public class SpiralOrder54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0 ) {
            return res;
        }
        int r = matrix[0].length - 1,d = matrix.length - 1,l = 0,u = 1;
        int col = 0,row = 0;
        while (r != 0) {
            while (col < r) {
                res.add(matrix[row][col++]);
            }
            r--;
            while (row < d) {
                res.add(matrix[row++][col]);
            }
            d--;
            while (col > l) {
                res.add(matrix[row][col--]);
            }
            l++;
            while (row > u) {
                res.add(matrix[row--][col]);
            }
            u++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        List<Integer> res = new LinkedList<>();
        res = spiralOrder(matrix);
        System.out.println(res.toString());
    }
}
