package aboveOneHundred;

/**
 * FileName: FindDuplicate
 * author: gxs
 * Date: 2021/9/21  17:30
 */
public class FindDuplicate {
    /**
     快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     即按照寻找链表环入口的思路来做
     **/
    public int findDuplicate(int[] nums) {
        int fast = 0,slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{1, 2, 3, 4, 4}));
    }
}
