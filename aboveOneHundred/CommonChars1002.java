package aboveOneHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: CommonChars1002
 * author: gxs
 * Date: 2023/1/31  19:17
 */
public class CommonChars1002 {
    /**
     * 方法 通过count数组统计字符出现的频率，再对比每一个字符串的这个数组，取count数组列的最小值
     * */
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] counter = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            counter[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] hashOtherStr = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                hashOtherStr[words[i].charAt(j) - 'a']++;
            }
//            对比列大小，更新counter，取最小值
            for (int k = 0; k < 26; k++) {
                counter[k] = Math.min(counter[k], hashOtherStr[k]);
            }
        }

        // 将hash统计的字符次数，转成输出形式
        for (int i = 0; i < 26; i++) {
            while (counter[i] != 0) {
                // 注意这里是while，多个重复的字符
                char c= (char) (i + 'a');
                result.add(String.valueOf(c));
                counter[i]--;
            }
        }
        return result;
    }
}
