/**
 * FileName: Exist12
 * author: gxs
 * Date: 2022/1/5  16:04
 */
public class Exist12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int x = board.length;
        int y = board[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                 if (backtrack(i, j, board, words, 0)) return true;
                }
            }
        return false;
    }
    private boolean backtrack(int i, int j, char[][] board, char[] word, int t) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[t]) {
            return false;
        }
        if (t == word.length - 1)
            return true;

        board[i][j] = '\0';
            boolean res = backtrack(i + 1, j, board, word, t + 1) ||
            backtrack(i - 1, j, board, word, t + 1) ||
            backtrack(i, j + 1, board, word, t + 1) ||
            backtrack(i, j - 1, board, word, t + 1);
            board[i][j] = word[t];

        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','a'}};
        String word = "aaa";
        System.out.println(new Exist12().exist(board, word));
    }
}
