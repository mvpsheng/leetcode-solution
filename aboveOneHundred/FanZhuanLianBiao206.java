package aboveOneHundred;

import java.util.LinkedList;

/**
 * FileName: FanZhuanLianBiao206
 * author: gxs
 * Date: 2021/9/23  21:22
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class FanZhuanLianBiao206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        FanZhuanLianBiao206 fanZhuanLianBiao206 = new FanZhuanLianBiao206();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        ListNode res = fanZhuanLianBiao206.reverseList(l1);
        while (res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}
