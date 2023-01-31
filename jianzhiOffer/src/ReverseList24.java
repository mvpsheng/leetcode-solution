/**
 * FileName: ReverseList24
 * author: gxs
 * Date: 2022/1/9  11:57
 */
public class ReverseList24 {
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                reverseHead = node;
            }
            node.next = pre;
            pre = node;
            node = next;
        }
        return reverseHead;
    }
}
