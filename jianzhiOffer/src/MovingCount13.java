/**
 * FileName: MovingCount13
 * author: gxs
 * Date: 2022/1/5  17:26
 */
public class MovingCount13 {
    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        return backtrack(m, n, 0, 0, k, visited);
    }
    public int backtrack(int m, int n, int row, int col, int k, int[][] visited) {
        int count = 0;
        if (enable(m, n, row, col, k, visited)) {
            visited[row][col] = 1;
            count = 1 + backtrack(m, n, row + 1, col, k, visited) + backtrack(m, n, row - 1, col, k, visited)
                    + backtrack(m, n, row, col + 1, k, visited) + backtrack(m, n, row, col - 1, k, visited);
        }
        return count;
    }
    public boolean enable(int m, int n, int row, int col, int k, int[][] visited) {
        return col >=0 && row >= 0 && row < m && col < n && getSum(row) + getSum(col) <= k && visited[row][col] == 0;
    }
    private int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount13().movingCount(3, 1, 0));
    }
}
