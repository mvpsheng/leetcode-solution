/**
 * FileName: Add65
 * author: gxs
 * Date: 2022/1/11  8:25
 */
public class Add65 {
    public int add(int a, int b) {
        int sum, carry;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
