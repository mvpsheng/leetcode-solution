package Day4;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: IntervalIntersection
 * author: gxs
 * Date: 2021/8/16  17:51
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0) return new int[0][];
        int m = firstList.length;
        int n = secondList.length;
        int i = 0,j = 0;
        List<int[]> list = new ArrayList<>();
        while(i < m && j < n){ //此处以first为基准取交集
            int a = firstList[i][0],b = firstList[i][1];
            int x = secondList[j][0], y = secondList[j][1];
            if(a > y) j++;
            else if(x > b) i++;
            else {
                list.add(new int[]{Math.max(a,x),Math.min(b,y)});
                if(y > b) i++;
                else j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
