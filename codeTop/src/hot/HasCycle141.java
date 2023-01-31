package hot;

/**
 * FileName: HasCycle141
 * author: gxs
 * Date: 2022/3/15  17:42
 */
public class HasCycle141 {
    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        if (head == null) return false;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) return true;
        }
        return false;
    }
}
