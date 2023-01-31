package tuyazhineng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * FileName: tuyazhineng.MaxLength
 * author: gxs
 * Date: 2021/9/2  11:13
 */
public class MaxLength {
    private static int maxLength(String test){
        StringBuffer s = new StringBuffer();
        Map<Integer,Integer> locations = new HashMap<>();//记录当前层级时的位置
        Map<Integer,Integer> lengths = new HashMap<>();//记录当前层级时的长度
        int lastLevel = 0;
        int maxLen = 0;
        int lastLocation = 0;
        for (int i = 0; i < test.length(); i++) {
            s.append(test.charAt(i));
            if (s.toString().endsWith("\t") && test.charAt(i + 1) != '\t'){
                int blen = s.length();
                s.replace(s.lastIndexOf("\n"), s.length(),"/");
                int slen = s.length();
                int level = blen - slen;
                //遇到相同上一个层级的目录时，记录当前层级的位置，根据位置删除上一个相同目录位置开始的字符串，并记录当前最长长度
                if (lastLevel == level){
                    maxLen = Math.max(s.length() - 1,maxLen);
                    locations.put(level,s.lastIndexOf("/"));
                    lengths.put(level,maxLen);
                   s.delete(lastLocation + 1, s.length());
                }else if (level > lastLevel){
                    //遇到大于上一个层级时，只记录当前层级的位置，并记录当前最长长度
                    locations.put(level,s.lastIndexOf("/"));
                    maxLen = Math.max(s.length() - 1,maxLen);
                    lengths.put(level,maxLen);
                 }else{
                    //遇到小于上一个层级，根据map找到上一次出现当前层级大小的位置，删除，并记录最大长度
                    maxLen = Math.max(s.length() - 1,maxLen);
                    lengths.put(level,maxLen);

                    int oldLocation = locations.get(level);
                    s.delete(oldLocation + 1, s.length());
                    locations.put(level,s.lastIndexOf("/"));
                }
                lastLevel = level ;
                lastLocation = s.lastIndexOf("/");
            }
        }
        return Math.max(s.length(),maxLen);
    }
    public static void main(String[] args) {
        String test = new String("Title\n\tSubtitle1\n\tSubtitle2\n\t\taaaa");
       System.out.println(maxLength(test));

    }
}
