package microsoft;

import java.util.*;

/**
 * FileName: Vertexs
 * author: gxs
 * Date: 2021/10/16  17:31
 */
public class Vertexs {
        public static void main(String[] args) {
            int k = new Vertexs().solution(5,new int[] {2,2,1,2},new int[] {1,3,4,4});
            System.out.println(k);
        }

        public int solution(int N, int[] A, int[] B) {
            // write your code in Java SE 8
            int result = 0;
            Map<Integer,Integer> degree = new TreeMap<>();
            int[] value = new int[N + 1];
            for (int i = 0; i < A.length; i++) {
                degree.put(A[i],degree.getOrDefault(A[i],0) + 1);
                degree.put(B[i],degree.getOrDefault(B[i],0) + 1);
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(degree.entrySet());

            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
                //升序排序
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            Iterator<Map.Entry<Integer, Integer>> it = list.iterator();
            int tmp = 1;
            while (it.hasNext()) {
                Map.Entry<Integer,Integer> entry = it.next();
                value[entry.getKey()] = tmp;
                tmp ++;
            }
            for (int i = 0; i < A.length; i++) {
                result += value[A[i]];
                result += value[B[i]];
            }
            return result;
        }
    }

