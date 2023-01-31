import java.util.HashMap;

/**
 * @auther gxs
 * @create 2021-01-22-20:05
 */
class MainElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int num = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i]))
                m.put(nums[i], 1);
            else
                m.put(nums[i], m.get(nums[i]) + 1);
        }
        System.out.println(m);
        for (int i = 0; i < nums.length; i++)

            if (m.get(nums[i]) > nums.length / 2)
                num = nums[i];
        System.out.println(num);

    }
}