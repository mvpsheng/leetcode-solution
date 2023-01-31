/**
 * FileName: MergeTwoLists25
 * author: gxs
 * Date: 2022/1/9  16:14
 */
public class MergeTwoLists25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mHead = null;
        if (l1.val < l2.val) {
            mHead = l1;
            mHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mHead = l2;
            mHead.next = mergeTwoLists(l1, l2.next);
        }
        return mHead;
    }
}
