/**
 * FileName: MajorityElement39
 * author: gxs
 * Date: 2022/1/16  18:51
 */
public class MajorityElement39 {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1: -1;
        }
        for (int num :
                nums) {
            if (num == x) count++;
        }
        return count > nums.length / 2 ? x : 0;
    }
}
