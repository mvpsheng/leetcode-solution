import java.util.Scanner;

/**
 * @auther gxs
 * @create 2021-01-23-17:47
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "";
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length-1; i >=0; i--) {
            if(s1[i].equals("")||s1[i].equals(" ")){
                continue;
            }
            sb.append(s1[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
