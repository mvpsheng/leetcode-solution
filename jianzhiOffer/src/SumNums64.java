/**
 * FileName: SumNums64
 * author: gxs
 * Date: 2022/1/11  8:21
 */
public class SumNums64 {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new SumNums64().sumNums(n));
    }
}
