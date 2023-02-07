package everydayOneQuestion;

import java.util.*;

/**
 * FileName: AlertNames1604
 * author: gxs
 * Date: 2023/2/7  8:05
 */
public class AlertNames1604 {
    /**
     *  0. 题号
     *      1604. 警告一小时内使用相同员工卡大于等于三次的人
     *  1. 约束分析
     *      名字和时间数组的长度一样，属于范围[1, 100000]
     *      名称数组只包含小写字母
     *      系统只统计某一天的情况，所以23，55之后就不算在一个小时之内了
     *      返回名字按字典序升序排列
     *  2. 思路
     *         双指针法，统计员工出现的次数，在第三次的时候，计算是否在一个小时之内，如果是，将名字接入结果集
     *  3. 数据结构与算法选择、复杂度分析
     *      时间： 两个数组同时遍历一次，所以是O(N)
     *      空间： 只需要常数个变量，所以是O(1)
     *  4. 核心代码
     *
     *  5. 测试
     * */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }

        List<String> res = new ArrayList<>();
        Set<String> keySet = timeMap.keySet();
        for (String name :
                keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int diff = time2 - time1;
                if (diff <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String[][] keyNames = {{"alice","alice","alice","bob","bob","bob","bob"},
                {"john","john","john"},
                {"clare","clare","clare","clare"}};
        String[][] keyTimes = {{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"},
                {"23:58","23:59","00:01"},
                {"18:00","18:51","19:30","19:49"}};
        for (int i = 2; i < keyNames.length; i++) {
            System.out.println(new AlertNames1604().alertNames(keyNames[i], keyTimes[i]));
        }
    }
}
