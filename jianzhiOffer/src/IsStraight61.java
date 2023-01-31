import java.util.HashSet;
import java.util.Set;

/**
 * FileName: IsStraight61
 * author: gxs
 * Date: 2022/1/17  9:36
 */
public class IsStraight61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num))
                return false;
            repeat.add(num);
        }
        return max - min < 5;
    }
}
