/**
 * FileName: GetKthFromEnd22
 * author: gxs
 * Date: 2022/1/9  11:31
 */
public class GetKthFromEnd22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode preHead = head;
        ListNode behind = null;

        for (int i = 0; i < k - 1; i++) {
            preHead = preHead.next;
        }
        behind = head;
        while (preHead.next != null) {
            preHead = preHead.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = new GetKthFromEnd22().getKthFromEnd(node1, 2);
        System.out.println(res.val);
    }
}
