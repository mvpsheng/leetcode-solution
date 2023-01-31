/**
 * FileName: DetectCycle22
 * author: gxs
 * Date: 2022/1/9  11:40
 */
public class DetectCycle22 {
    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = meetNode(head);
        if (meetNode == null) return null;
//        得到环中的数目
        int nodesInLoop = 1;
        ListNode node1 = meetNode;
        while (node1.next != meetNode) {
            node1 = node1.next;
            ++nodesInLoop;
        }
//       先移动node1,次数为环中节点数目
        node1 = head;
        for (int i = 0; i < nodesInLoop; i++) {
            node1 = node1.next;
        }
//        在移动node2和node1
        ListNode node2 = head;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    ListNode meetNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}
