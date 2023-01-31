package ex1;

/**
 * FileName: MajorityNumber
 * author: gxs
 * Date: 2021/10/8  20:04
 */

import java.util.*;

/**
 * 问题描述：一个数出现的频率叫重数，重数最大的数字叫众数
 * */
public class MajorityNumber {
    public int[] majorityNumber(int n, int[] nums) {
        if (n < 0) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        Map.Entry<Integer, Integer> entry = list.get(0);
        res[0] = (Integer) entry.getKey();
        res[1] = (Integer) entry.getValue();
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,5};
        int[] ans = new MajorityNumber().majorityNumber(6,nums);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
