import java.util.Arrays;

/**
 * @auther gxs
 * @create 2021-01-25-9:07
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int [] s = {2, 3,3,4,4,4,4,4, 1, 0, 2, 5, 3};
        int[] s1 = new int[s.length];
        int i = 1;
        int count = 0;
        Arrays.sort(s);
        for (int j = 0; j < s.length; j++) {
            System.out.print(s[j]+" ");
        }

        while (!(0 == i)) {
            if(s[count]==s[count+1]){
                if(s[count+1]!=s1[count])
                s1[count] = s[count];
            }
            count++;
            if (s[count]==s[s.length-1]){
                i=0;
            }
        }
        System.out.println(count);
        System.out.println(s[s.length-1]);
        for (int j = 0; j < s1.length; j++) {
            System.out.print(s1[j]+" ");
        }

    }
}
