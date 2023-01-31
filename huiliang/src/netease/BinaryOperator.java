package netease;

/**
 * FileName: BinaryOperator
 * author: gxs
 * Date: 2021/9/18  20:25
 */
public class BinaryOperator {
    public int recursion(int num) {
        int index = 0;//幂级数
        while (num > 1) {
            num = num >> 1;
            index++;
        }
        return index;
    }
    public int operatorNum(int n) {
        if (n % 2 == 0) {
            return 1;
        }
        int counts = 0;
        int index = 0;//幂级数
        int tmp = n;
        while (n > 1) {
            n = n >> 1;
            index++;
        }
        int other = (int) (tmp - Math.pow(2,index));
        if (other > index) {
            int second = (int) (Math.pow(2,counts + 1) - tmp);
        }

        return other + 1;
    }

    public static void main(String[] args) {
        BinaryOperator binaryOperator = new BinaryOperator();
        System.out.println(binaryOperator.operatorNum(30));
    }
}
