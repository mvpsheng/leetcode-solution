import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FileName: Intersection349
 * author: gxs
 * Date: 2023/2/2  11:15
 */
public class Intersection350 {
/**
 * 返回数组相交的部分
 *  1. 分析约束条件
 *      两个数组长度都大于等于1，小于1000
 *      两个数组中数字大小[0, 1000]
 *  2. 数据结构和算法选择
 *      使用集合Set，因为要返回唯一的重复项，且不考虑顺序
 *      直接分别遍历两个数组集合
 *  3. 复杂度分析
 *      时间： 遍历一遍数组 所以是O(N)
 *      需要用set存储所以是O(N)
 *  4. 核心代码
 *
 *  5. 测试
 *
 * */
    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set1 = new HashSet<>();
        List<Integer> reList = new ArrayList<>();
//
//        for (int num : nums1) {
//            set1.add(num);
//        }
//        for (int num : nums2) {
//            if (set1.contains(num)) {
//                reSet.add(num);
//            }
//        }
//        方法二：因为数值在0，1000之内，hash值不大，所以用数组来做hash也可以。
        int[] hash = new int[1001];
        for (int num : nums1) {
            hash[num]++;
        }
        for (int num : nums2) {
            if (hash[num] != 0) {
                reList.add(num);
                hash[num]--;
            }
        }
//        集合转换为int数组
        return reList.stream().mapToInt(x -> x).toArray();
    }
}
