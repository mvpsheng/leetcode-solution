package hot;

import java.util.List;

/**
 * FileName: ReverseBetween92
 * author: gxs
 * Date: 2021/11/24  21:09
 */
public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
//        定义一个dummyHead，方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

//        初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

//        将指针移动到响应的位置
        for (int step = 0; step < left - 1; step++) {
            g = g.next;
            p = p.next;
        }
//        头插法插入节点
        for (int i = 0; i < right - left; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }
}
