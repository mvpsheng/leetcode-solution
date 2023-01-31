package day1;

/**
 * FileName: ContainsDuplicate
 * author: gxs
 * Date: 2022/1/27  12:54
 */

import java.util.HashSet;

/**
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            if (!hashset.add(num)) {
                return true;
            }
        }
        return false;
    }
}
