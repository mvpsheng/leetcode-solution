package ThirdTen;

/**
 * FileName: TwentyOne
 * author: gxs
 * Date: 2021/9/17  22:18
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class TwentyOne {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode res = new ListNode();
        while (l1.next != null || l2.next != null) {
            if (l1.next == null) {
                res.next = l2.next;
            }
            if (l2.next == null) {
                res.next = l1.next;
            }
            if (l1.val <= l2.val) {
                res.val = l1.val;
                l1 = l1.next;
                res = res.next;
            } else {
                res.val = l2.val;
                l2 = l2.next;
                res = res.next;
            }

        }
        return res;
    }
}
