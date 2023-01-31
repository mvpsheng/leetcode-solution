package tuyazhineng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * FileName: tuyazhineng.Test
 * author: gxs
 * Date: 2021/9/2  16:35
 */
public class Test {
/**
 * 一个stringBuffer来存储字符串完成遍历
 * 两个hashMap，一个用来存储上一次出现不同层目录的位置（location），另一个存储不同层目录出现的长度（length）
 * */

    public static void main(String[] args) {
//        String test = new String("Title\n\tSubtitle1\n\t\taaa\n\t\tSubsubtitle1" +
//                "\n\t\t\tbbbb\n\tSubtitle2\n\t\tSubsubtitle2\n\t\t\tcccccc");
//        StringBuffer s = new StringBuffer();
//        Map<Integer,Integer> locations = new HashMap<>();//记录当前层级时的位置
//        Map<Integer,Integer> lengths = new HashMap<>();//记录当前层级时的长度
//        int lastLevel = 0;
//        int maxLen = 0;
//        int lastLocation = 0;
//        for (int i = 0; i < test.length(); i++) {
//            s.append(test.charAt(i));
//            if (s.toString().endsWith("\t") && test.charAt(i + 1) != '\t'){
//                int blen = s.length();
//                System.out.println(s.replace(s.lastIndexOf("\n"), s.length(),"/"));
//                int slen = s.length();
//                int level = blen - slen;
//                //遇到相同上一个层级的目录时，记录当前层级的位置，根据位置删除上一个相同目录位置开始的字符串，并记录当前最长长度
//                if (lastLevel == level){
//                    maxLen = Math.max(s.length() - 1,maxLen);
//                    locations.put(level,s.lastIndexOf("/"));
//                    lengths.put(level,maxLen);
//                    System.out.println(maxLen+"当前最大长度");
//                    System.out.println(s.lastIndexOf("/")+"当前层级开始位置");
//                    System.out.println(s.delete(lastLocation + 1, s.length())+"遇到层级相同,删除了上一个相同层级后的样子");
//                }else if (level > lastLevel){
//                    //遇到大于上一个层级时，只记录当前层级的位置，并记录当前最长长度
//                    locations.put(level,s.lastIndexOf("/"));
//                    maxLen = Math.max(s.length() - 1,maxLen);
//                    lengths.put(level,maxLen);
//                    System.out.println(maxLen+"当前最大长度");
//                    System.out.println(s.lastIndexOf("/")+"当前层级开始位置");
//                }else{
//                    //遇到小于上一个层级，根据map找到上一次出现当前层级大小的位置，删除，并记录最大长度
//                    maxLen = Math.max(s.length() - 1,maxLen);
//                    lengths.put(level,maxLen);
//
//                    int oldLocation = locations.get(level);
//                    System.out.println(level);
//                    System.out.println(maxLen+"当前最大长度");
//                    System.out.println(oldLocation+"当前层级开始位置");
//                    System.out.println(s.delete(oldLocation + 1, s.length())+"遇见大于上一个目录删除了上一个相同层级后的样子");
//                    locations.put(level,s.lastIndexOf("/"));
//                }
//
//                System.out.println(level);
//                //将当前的level位置存入哈希
//
//                lastLevel = level ;
//                lastLocation = s.lastIndexOf("/");
//            }
//        }
//        System.out.println(s);
//        System.out.println(Math.max(s.length(),maxLen));
//    }
}
}

