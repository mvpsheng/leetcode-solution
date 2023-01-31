package Day3;

import java.util.List;

/**
 * FileName: DeleteDuplicates
 * author: gxs
 * Date: 2021/8/16  11:36
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {this.val =val;}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
