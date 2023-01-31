package recursionanddynamicprogramming;

/**
 * FileName: MagicIndex
 * author: gxs
 * Date: 2022/1/22  15:06
 */
/* a magic index is an array A[1...n - 1] is defined to be an index such that A[i] = i. Given a sorted
 * array of distinct integers, write a method to find a magic index, if one exists, in array A */

public class MagicIndex {
    public static int magicIndex(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }
        int mid = (start + end) / 2 ;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicIndex(array, start, mid - 1);
        } else {
            return magicIndex(array, mid + 1, end);
        }
    }

    public static int magicIndex(int[] array) {
        return magicIndex(array, 0, array.length - 1);
    }
}
