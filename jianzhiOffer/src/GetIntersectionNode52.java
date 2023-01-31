/**
 * FileName: GetIntersectionNode52
 * author: gxs
 * Date: 2022/1/10  16:51
 */
public class GetIntersectionNode52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        得到两个链表的长度
        int length1 = getListLength(headA);
        int length2 = getListLength(headB);
        int lenDif = length1 - length2;

        ListNode headLong = headA;
        ListNode headShort = headB;
        if (length2 > length1) {
            headLong = headB;
            headShort = headA;
            lenDif = length2 - length1;
        }

//        先在长链表上走几步，同时在两个链表上遍历
        for (int i = 0; i < lenDif; i++) {
            headLong = headLong.next;
        }

        while (headLong != null && headShort != null && headLong != headShort) {
            headLong = headLong.next;
            headShort = headShort.next;
        }

//        得到第一个公共节点
        ListNode firstCommonNode = headLong;
        return firstCommonNode;
    }
    private int getListLength(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            ++len;
            node = node.next;
        }
        return len;
    }
}
