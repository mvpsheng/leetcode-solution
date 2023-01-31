package onehundred;

import java.util.List;

/**
 * FileName: DeleteDuplicates83
 * author: gxs
 * Date: 2022/12/7  9:49
 * name: 删除有序链表中的重复元素
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class DeleteDuplicates83 {
//已经排序的数组，删除重复元素， 数量 [0-300]
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
//        拿到第一个元素， 往后看值， 如果相同， next指针指向下一个元素
//        借助两个节点， 一个是当前对比节点， 一个是用于定位当前重复元素的节点
        ListNode cur = head.next;
        ListNode pre = head;
//        如果当前节点的下一个已经为空, 则整个链表已经处理完成
        while (cur != null) {
            //        如果pre和cur相同， 将cur 移动到下一个节点， 这种方式来删除重复元素
            if (pre.val == cur.val) {
                cur = cur.next;
                pre.next = cur;

            } else { // 否则两个节点同时移动，去尝试判断下一个重复节点
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
