package netease;

import java.util.Scanner;

/**
 * FileName: BoardMoves
 * author: gxs
 * Date: 2021/9/18  19:22
 */
public class BoardMoves {
    public int moves(String str,int num) {
        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }
        int count = 1;
        boolean flag = false;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
//                判断两者绝对值差是否大于1
                int abs = Math.abs(str.charAt(i) - str.charAt(i - 1));
                if (abs > 1) {
                    if (num > 0) {
//                        有魔法键用魔法
                        num--;
                        flag = true;
                        count += 2;
                    }  else {
//                        没魔法键算插值
                       flag = false;
                       if (abs <= 13) {
                           count += abs + 1;
                       } else {
                           count += 26 - abs + 1;
                       }
                    }
                } else {
                    count += 2;
                }
            } else {
//                两个相同情况
                if (num > 0 && flag) {
                    count += 2;
                    num--;
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BoardMoves moves = new BoardMoves();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = 0;
        char[][] metrics = new char[n][n];
        for (int i = 0; i < n;i++) {
            for (int j = 0;j < n;j++) {
                metrics[i][j] = sc.next().charAt(j);
            }
        }
        while (sc.hasNext()) {
         sb.append(sc.next());
        }
        System.out.println(moves.moves(sb.substring(0,sb.length() - 1),Integer.parseInt(sb.substring(sb.length() - 1))));
    }
}
