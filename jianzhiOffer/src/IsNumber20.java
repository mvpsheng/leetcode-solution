/**
 * FileName: IsNumber20
 * author: gxs
 * Date: 2022/1/8  18:07
 */
public class IsNumber20 {
    static int index = 0;
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        boolean numeric = scanInteger(s);
        if (index < s.length() && s.charAt(index) == '.') {
            index++;
            numeric = scanUnsignedInteger(s.substring(index)) ||
                    numeric;
        }
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E' )) {
            index++;
            numeric = numeric && scanInteger(s.substring(index));
        }
        return numeric;
    }

    boolean scanUnsignedInteger(String s) {
        int before = index;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '\0'
                    && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                index++;
            }
        }
        return index > before;
    }

    boolean scanInteger(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
               index = i + 1;
            }
        }
        return scanUnsignedInteger(s.substring(index));
    }

    public static void main(String[] args) {
        String s = "3";
        System.out.println(new IsNumber20().isNumber(s));
    }
}
