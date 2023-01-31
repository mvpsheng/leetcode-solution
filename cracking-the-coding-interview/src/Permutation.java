/**
 * FileName: Permutation
 * author: gxs
 * Date: 2022/1/18  14:44
 */
// Given two strings, write a method to decide if one is a permutation of the other

public class Permutation {
    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256];
        char[] s_Array = s.toCharArray();
        for (char c : s_Array) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = (int)t.charAt(i);
            if (--letters[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "adpc";
        String t = "pcad";
        System.out.println(new Permutation().permutation(s, t));
    }
}
