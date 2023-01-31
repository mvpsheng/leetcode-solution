import java.util.HashMap;
import java.util.HashSet;

/**
 * FileName: Test
 * author: gxs
 * Date: 2022/1/27  12:46
 */
public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashset = new HashSet<>();
        hashMap.put(3, 1);
        hashMap.put(3, 2);
        int[] nums = {1, 2, 3, 1};
        for (int num : nums) {
            if (!hashset.add(num)) {
                System.out.println(true);
            }
        }
    }
}
