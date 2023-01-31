/**
 * FileName: FindNthDigit44
 * author: gxs
 * Date: 2022/1/16  18:07
 */
public class FindNthDigit44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
//        解法一：
//        int digits = 1;
//        while (true) {
//            int numbers = countOfIntegers(digits);
//            if (n < numbers * digits) {
//                return digitAtIndex(n, digits);
//            }
//            n -= digits * numbers;
//            digits++;
//        }
    }
    int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }

        return (int) Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int n = 1000000000;
     //   System.out.println(x - n);
        System.out.println(new FindNthDigit44().findNthDigit(n));
    }
}
