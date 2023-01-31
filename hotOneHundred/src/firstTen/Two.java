package firstTen;

/**
 * FileName: Two
 * author: gxs
 * Date: 2021/9/22  19:53
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Two {
//    l1 = [2,4,3], l2 = [5,6,4]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l12 = new ListNode(7);
        ListNode l23 = new ListNode(2);
        ListNode l13 = new ListNode(5);
        l1.next = l12;
        l2.next = l22;
        l12.next = l13;
        l22.next = l23;
        Two t = new Two();
        ListNode listNode = t.addTwoNumbers(l1,l2);
        if (listNode != null) {
            while (listNode != null) {
                System.out.print(" "+listNode.val);
                listNode = listNode.next;
            }
        }

    }
}
