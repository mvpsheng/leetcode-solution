package hot;

/**
 * FileName: MinWindow76
 * author: gxs
 * Date: 2021/11/22  18:50
 */
public class MinWindow76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
//        记录当前需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
//        l是左边界，r是当前有边界，size记录窗口大小，count为需求的字符个数
//        start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(),
                start = 0;
//        遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {
//                需要该字符c
                count--;
            }
//            右边字符加入窗口
            need[c]--;
            if (count == 0) {
//                窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
//                    释放左边移动出窗口的字符
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        String s = "abfghc";
        System.out.println();
    }
}
