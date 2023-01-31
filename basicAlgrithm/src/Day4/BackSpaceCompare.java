package Day4;

/**
 * FileName: BackSpaceCompare
 * author: gxs
 * Date: 2021/8/16  17:15
 */
public class BackSpaceCompare {
    public static boolean backspaceCompare(String s, String t) {
       return back(s).equals(back(t));
    }
    public static String back(String str){
        StringBuilder stringBuilder = new StringBuilder();
        int lens = str.length();
        for (int i = 0; i < lens; ++i) {
            char x = str.charAt(i);
            if(x != '#'){
                stringBuilder.append(x);
            }else{
                if (stringBuilder.length() > 0){
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s1 = "ab#c";
        String s2 = "ad#c";
        System.out.println(backspaceCompare(s1, s2));
    }
}
