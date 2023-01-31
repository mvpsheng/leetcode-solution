/**
 * FileName: IsRotation
 * author: gxs
 * Date: 2022/1/18  14:28
 */
// Assume you have a method isSubstring which checks if one word is a isSubstring of another.
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
// one call to isSubstring(e.g., "waterbottle" is a rotation of "erbottlewat").

public class IsRotation {
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
/*check that s1 and s2 are equal length and not empty*/
        if (len == s2.length() && len > 0) {
/* concatenate s1 and s1 within new buffer */
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }
        return false;
    }
    public boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(new IsRotation().isRotation(s1, s2));
    }
}
