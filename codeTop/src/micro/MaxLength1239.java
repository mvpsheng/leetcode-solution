package micro;

import java.util.LinkedList;
import java.util.List;

/**
 * FileName: MaxLength1239
 * author: gxs
 * Date: 2022/1/29  15:42
 */
public class MaxLength1239 {
    public int maxLength(List<String> arr) {
        int[] result = new int[1];
        maxUnique(arr, 0, "", result);
        return result[0];
    }

    public void maxUnique(List<String> arr, int index, String current, int[] result) {
        if (index == arr.size() && uniqueCharCount(current) > result[0]) {
            result[0] = current.length();
            return;
        }
        if (index == arr.size()) {
            return;
        }
        maxUnique(arr, index + 1, current, result);
        maxUnique(arr, index + 1, current + arr.get(index), result);
    }

    public int uniqueCharCount(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            if (counts[c - 'a']++ > 0) {
                return -1;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        List<String> arr = new LinkedList<>();
        arr.add("cha");
        arr.add("r");
        arr.add("act");
        arr.add("ers");
        System.out.println(new MaxLength1239().maxLength(arr));
    }
}
