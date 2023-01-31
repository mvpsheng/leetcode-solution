package tencent;


import java.util.List;

/**
 * FileName: ReorderList143
 * author: gxs
 * Date: 2021/12/3  15:43
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
//        求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }
        rListHelper(head,len);
    }
    private ListNode rListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        ListNode tail = rListHelper(head.next,len - 2);
        ListNode subHead = head.next;//中间链表的头节点
        head.next = tail; //将首尾部节点连接起来
        ListNode outTail = tail.next;
        tail.next = subHead; //当前尾部节点的下一个为第二个头节点
        return outTail;
    }
}
