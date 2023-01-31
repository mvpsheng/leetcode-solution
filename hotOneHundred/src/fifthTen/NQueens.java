package fifthTen;

import java.util.*;

/**
 * FileName: NQueens
 * author: gxs
 * Date: 2021/12/25  11:48
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
//        三个set分别记录不同列，两条对角线的占用情况
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> diagonalSet1 = new HashSet<>();
        Set<Integer> diagonalSet2 = new HashSet<>();
//        初始化结果集
        List<List<String>> result = new ArrayList<>();
        String[][] current = new String[n][n];
        for (String[] s : current) {
            Arrays.fill(s, ".");
        }
        backtrack(result, 0, n, current, columnSet, diagonalSet1, diagonalSet2);
        return result;
    }
    public void backtrack(List<List<String>> result, int row, int n,String[][] current,
                          Set<Integer> columnSet,
                          Set<Integer> diagonalSet1,
                          Set<Integer> diagonalSet2) {
        if (row == n) {
               result.add(transfer(current));
            }
//            List<String> board = generatedBoard(queens, n);
//            ans.add(board);
        for (int column = 0; column < n; column++) {
            if (columnSet.contains(column) || diagonalSet1.contains(column - row) ||
            diagonalSet2.contains(column + row)) {
                continue;
//                该位置不符合条件，跳出该层循环
            }
            current[row][column] = "Q";
            columnSet.add(column);
            diagonalSet1.add(column - row);
            diagonalSet2.add(column + row);
            backtrack(result, row + 1, n, current, columnSet, diagonalSet1, diagonalSet2);
            current[row][column] = ".";
            columnSet.remove(column);
            diagonalSet1.remove(column - row);
            diagonalSet2.remove(column + row);
        }
    }
    public List<String> transfer(String[][] current) {
       String[] result = new String[current.length];
        for (int i = 0; i < current.length; i++) {
           StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < current[i].length; j++) {
                stringBuilder.append(current[i][j]);
            }
            result[i] = stringBuilder.toString();
        }
        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4).toString());
    }
}
