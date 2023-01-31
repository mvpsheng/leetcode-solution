package fourthTen;

import java.util.*;

/**
 * FileName: GroupAnagrams49
 * author: gxs
 * Date: 2023/1/31  18:43
 */
public class GroupAnagrams49 {
    // 将第一个字符串加入结果集， 新的字符串时，
    // 遍历结果集判断当前结果集是否为异位词，如果是，加入这个结果集
    // 判断异位词的只需要遍历一遍，所以时间复杂度为O(N)
    // 循环判断当前结果集是否符合也是O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * 方法1： 排序来判断异位词
         *  一个字符串排序后，异位词排序后都相同，将这个作为key，那么key如果存在map中，就获取list，然后list加入str
         *  map中没有key，新建一个list，然后一起加入map
         *  最后返回map中的value集合
         * */
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String key = Arrays.toString(cArray);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        /**
         * 方法2： 计数来判断异位词
         *  通过统计一个出现的字母和其出现的次数拼接成的字符串，判断异位词，将这个字符串作为map的key值
         *
         * */
//        for (String str : strs) {
//            int[] counter = new int[26];
//            for (int i = 0; i < str.length(); i++) {
//                counter[str.charAt(i) - 'a']++;
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < 26; i++) {
//                if (counter[i] != 0) {
//                    sb.append((char)(i + 'a'));
//                    sb.append(counter[i]);
//                }
//            }
//            String key = sb.toString();
//            List<String> list = map.getOrDefault(key, new ArrayList<String>());
//            list.add(str);
//            map.put(key, list);
//        }
        return new ArrayList<List<String>>(map.values());
    }
    /**
     *  方法功能：
     *      判断是否为异位词
     * */
    public boolean isAnagram(String s, String t) {

        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
