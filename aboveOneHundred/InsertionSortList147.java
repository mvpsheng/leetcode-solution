package aboveOneHundred;

/**
 * FileName: InsertionSortList147
 * author: gxs
 * Date: 2021/9/27  15:51
 */
public class InsertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
//        用于从头寻找插入点的假头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
//        保存已经有序序列的尾节点，cur为未排序元素的首节点
        ListNode lastSorted = head,cur = head.next;
        while (cur != null) {
//            首先判断队尾和未排序的元素大小，如果待排序元素比较大，就直接连在队尾。
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
//                否则创建一个前指针,从头开始遍历,直到找到了插入位置
                ListNode prev = dummyHead;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
//                找到插入位置之后进行插入操作
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }
}
