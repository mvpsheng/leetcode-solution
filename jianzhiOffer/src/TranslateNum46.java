/**
 * FileName: TranslateNum46
 * author: gxs
 * Date: 2022/1/16  11:48
 */
public class TranslateNum46 {
    public int translateNum(int num) {
        String number = String.valueOf(num);
        return getTranslationCount(number);
    }
    int getTranslationCount(String num) {
        int len = num.length();
        char[] numbers = num.toCharArray();
        int[] counts = new int[len];
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            count = 0;
            if (i < len - 1) {
                count = counts[i + 1];
            } else
                count = 1;

            if (i < len - 1) {
                int digit1 = numbers[i] - '0';
                int digit2 = numbers[i + 1] - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < len - 2)
                        count += counts[i + 2];
                    else
                        count += 1;
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }

    public static void main(String[] args) {
        int x = 12258;
        System.out.println(new TranslateNum46().translateNum(x));
    }
}
