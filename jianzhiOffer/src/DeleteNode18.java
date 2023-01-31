/**
 * FileName: DeleteNode18
 * author: gxs
 * Date: 2022/1/7  17:21
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class DeleteNode18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head,
                cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }
}
