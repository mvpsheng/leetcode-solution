package hot;

/**
 * FileName: DetectCycle142
 * author: gxs
 * Date: 2022/3/15  18:29
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head,
         s = head;
        do {
            if (f == null || f.next == null) return null;
            f = f.next.next;
            s = s.next;
        } while (f != s);
        f = head;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
