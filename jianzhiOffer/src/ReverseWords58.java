/**
 * FileName: ReverseWords58
 * author: gxs
 * Date: 2022/1/13  13:18
 */
public class ReverseWords58 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) continue;
            res.append(strs[i] + " ");
        }
        return res.toString().trim();
    }
}
