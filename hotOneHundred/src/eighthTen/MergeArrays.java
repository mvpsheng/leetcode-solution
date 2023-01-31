package eighthTen;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * FileName: MergeArrays
 * author: gxs
 * Date: 2021/9/25  20:57
 */
public class MergeArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//解法一：时间复杂度(M+N)log（M+N）  空间复杂度：log（m+n）
        //        for (int i = 0;i != n;i++) {
//            nums1[m + i] = nums2[i];
//        }
//        Arrays.sort(nums1);

//        解法二：双指针，时间复杂度O（M+N） 空间复杂度O（M+N）
//        int p1 = 0,p2 = 0;
//        int[] sorted = new int[m + n];
//        int cur;
//        while (p1 < m || p2 < n) {
//            if (p1 == m) {
//                cur = nums2[p2++];
//            } else if (p2 == n) {
//                cur = nums1[p1++];
//            } else if (nums1[p1] < nums2[p2]) {
//                cur = nums1[p1++];
//            } else {
//                cur = nums2[p2++];
//            }
//            sorted[p1 + p2 - 1] = cur;
//        }
//        for (int i = 0;i != m + n;++i) {
//            nums1[i] = sorted[i];
//        }

//        解法三：逆向双指针：时间复杂度O（m+n），空间复杂度O（1）
        int p1 = m - 1,p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == 0) {
                cur = nums2[p2--];
            } else if (p2 == 0) {
                cur = nums2[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
