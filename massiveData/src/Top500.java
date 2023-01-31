import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * FileName: Top500
 * author: gxs
 * Date: 2021/11/10  20:34
 */

public class Top500 implements Comparable<Top500> {
/**
 * 数值
 * */
    private int value;
/**
 * 记录数值来源的数组
 * */
    private int source;
/**
 * 记录数值在数组中的索引
 * */
    private int index;

    public int getValue() {
        return value;
    }

    public int getSource() {
        return source;
    }

    public int getIndex() {
        return index;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Top500(int value, int source, int index) {
        this.value = value;
        this.source = source;
        this.index = index;
    }

    @Override
    public int compareTo(Top500 o) {
        return Integer.compare(o.getValue(),this.value);
    }
}
class Test {
    public static int[] getTop(int[][] data) {
        int rowSize = data.length;
        int columnSize = data[0].length;

//        创建一个ColumnSize大小的数组，存放结果
        int[] result = new int[columnSize];

        PriorityQueue<Top500> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < rowSize; i++) {
//            将每个数组中最大的一个元素放入堆中
            Top500 d = new Top500(data[i][0],i,0);
            maxHeap.add(d);
        }

        int num = 0;
        while (num < columnSize) {
//            删除堆顶元素
            Top500 d = maxHeap.poll();
            result[num++] = d.getValue();
            if (num >= columnSize) {
                break;
            }
            d.setValue(data[d.getSource()][d.getIndex() + 1]);
            d.setIndex(d.getIndex() + 1);
            maxHeap.add(d);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = {
                {29, 17, 14, 2, 1},
                {19, 17, 16, 15, 6},
                {30, 25, 20, 14, 5}
        };
        int[] top = getTop(data);
        System.out.println(Arrays.toString(top));
    }
}
