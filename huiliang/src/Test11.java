import java.util.Scanner;

/**
 * FileName: Test11
 * author: gxs
 * Date: 2021/9/11  17:24
 */
public class Test11 {
    static int sum = 0;
    public static int getCount(int n){
        dfs(n - 1,0);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 3;
        System.out.println(getCount(i));
    }
    public static void dfs(int n,int l){
        if (l > n) return;
        if (l + 1 == n) sum ++;
        if (l + 2 == n) sum ++;
        if (l + 3 == n) sum ++;
        if (l + 4 == n) sum ++;
        if (l + 5 == n) sum ++;
        if (l + 6 == n) sum ++;
        dfs(n,l+1);
        dfs(n,l+2);
        dfs(n,l+3);
        dfs(n,l+4);
        dfs(n,l+5);
        dfs(n,l+6);
    }
}
