import java.util.*;

/**
 * @auther gxs
 * @create 2021-01-23-18:26
 */
public class ExchangeNumbers {
    public static void main(String[] args) {
        int[] s = {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        int a = 0;
        int b = s.length-1;
        int[] s1 = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            if (s[i]%2!=0){
                s1[a++] = s[i];
            }else
                s1[b--] = s[i];
        }
        for (int i = 0; i < s.length; i++) {
            System.out.print(s1[i]+",");
        }

    }
}
