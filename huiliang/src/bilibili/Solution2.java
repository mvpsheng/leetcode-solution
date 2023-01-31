package bilibili;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * FileName: Solution2
 * author: gxs
 * Date: 2021/9/7  18:15
 */
public class Solution2 {
    public static int GetFragment (String str) {
        // write code here
        //处理完一边，字符串的信息就都存储起来了。下一步是计算平均值
        Map<Character,Integer> map = new HashMap<>();
        int average = 0;
        int sum = 0;
        for(int i = 0;i < str.length();i++){
            char cs = str.charAt(i);
            if(!map.containsKey(cs)){
                map.put(cs,1);
            }else{
                if(cs == str.charAt(i - 1)){
                    map.put(cs,(Integer)map.get(cs)+1);
                }
            }
        }
        Set<Character> chars = map.keySet();
        Character[] nums =  (Character[])chars.toArray();
        for (int i = 0; i < map.size(); i++) {
           sum += map.get(nums[i]);
        }
        return (int)sum/map.size();
    }

    public static void main(String[] args) {
        System.out.println(GetFragment("aaabbaaac"));
    }
}
