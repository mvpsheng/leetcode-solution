/**
 * FileName: MissingNumber53
 * author: gxs
 * Date: 2021/11/16  17:20
 */
public class MissingNumber53 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        for (int num :
                nums) {
            total -= num;
        }
        return total;
    }
}
