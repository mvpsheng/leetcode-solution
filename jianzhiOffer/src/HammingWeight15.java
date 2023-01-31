/**
 * FileName: HammingWeight15
 * author: gxs
 * Date: 2022/1/6  12:16
 */
public class HammingWeight15 {
    public int hammingWeight(int n) {
        int count = 0;

        while (n > 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingWeight15().hammingWeight(00000000000000000000000000001011));
    }
}
