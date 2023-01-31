package firstTen;

/**
 * FileName: IsMatch10
 * author: gxs
 * Date: 2022/12/8  12:27
 * name: s 串是否可以用p串表示
 */
public class IsMatch10 {
    public boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        char [] ss = s.toCharArray();
        char [] ps = p.toCharArray();
        int n = s.length(), m = p.length();
        boolean [][] dp = new boolean[n+1][m+1];
//        dp的两个index分别表示 s的index 和 p的index ， 值是否匹配
        dp[0][0] = true;
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(ps[j-1] == ss[i-1] || ps[j-1] == '.'){
//                    如果 当前两个字符相同， 或者 p为‘.’ 则匹配成功， 接下来对比前一组字符
                    dp[i][j] = dp[i-1][j-1];
                }else if(ps[j-1] == '*'){
//                    当前字符为 ‘*’的情况
                    if(ps[j-2] != ss[i-1] && ps[j-2] != '.'){
//                        如果当前p的前一个不等于 s，且不等于‘.’, 则去判断 在往前前一个
                        dp[i][j] = dp[i][j-2];
                    }else{
//                        如果是等于以上两种其中一种
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        System.out.println(new IsMatch10().isMatch(s, p));
    }
}
