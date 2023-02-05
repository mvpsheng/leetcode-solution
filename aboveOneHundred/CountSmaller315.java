package aboveOneHundred;

import java.util.LinkedList;
import java.util.List;

/**
 * FileName: CountSmaller315
 * author: gxs
 * Date: 2023/1/30  16:55
 */
public class CountSmaller315 {
    /**
     * 1. 分析约束条件
     *      nums的长度大于等于1
     *      nums数组中的元素有正有负
     * 2. 数据结构和算法
     *      用归并排序中的归并过程来统计这个数右边小于它的元素个数
     * 3. 算法复杂度
     *      时间复杂度：因为过了一遍归并排序，所以时间复杂度为O(NLogN);
     *      空间复杂度：用到了几个n大小的辅助数组，所以空间复杂度为O(N)。
     * 4. 核心代码
     *      统计当一个数和右边要合并的数组中元素比较的过程中，碰到了比它大的元素，
     *      该元素索引为J， 右边数组的开始元素下标为Mid + 1，
     *      所以比它小的元素个数为 j - mid - 1个。
     *
     *      但是在归并排序的过程中元素的下标会改变，所以用一个数值对的数组来记录初始状态。
     * 5. 测试
     *      [
     * */
    private class Pair {
        int val, id;
        Pair(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }

//    归并排序所用的辅助数组
    private Pair[] temp;

    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        temp = new Pair[n];
        Pair[] arr = new Pair[n];

//        记录元素原始索引位置
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

//        执行归并排序，并统计结果Count
        sort(arr, 0, n - 1);
        List<Integer> res = new LinkedList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void sort(Pair[] arr, int lo, int hi) {
        if (lo == hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(Pair[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                arr[p] = temp[j++];
            } else if (j == hi + 1) {
                arr[p] = temp[i++];
//                更新count数组
                count[arr[p].id] += j - mid - 1;
            } else if (temp[i].val > temp[j].val) {
                arr[p] = temp[j++];
            } else {
                arr[p] = temp[i++];
//                更新count数组
                count[arr[p].id] += j - mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] testNums = {
                {1},
                {1, 1},
                {1, -1},
                {-1, 1},
                {1, 2, 2, 3},
                {1, -1, -2, -3, 2}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println(new CountSmaller315().countSmaller(testNums[i]));
        }
    }
}
