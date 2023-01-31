package hot;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * FileName: MergeKLists
 * author: gxs
 * Date: 2021/9/30  10:33
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode fakeHead = new ListNode(0),
                p = fakeHead;
        int k = lists.length;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(k,new Comparator<ListNode>(){
            public int compare(ListNode a,ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }

        }
            while (!heap.isEmpty()) {
                ListNode node = heap.poll();

                p.next = node;
                p = p.next;
                if (node.next != null) {
                    heap.offer(node.next);
                }
            }
            return fakeHead.next;
}

}
