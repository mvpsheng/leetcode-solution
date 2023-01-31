package linkedlist;

/**
 * FileName: Partition
 * author: gxs
 * Date: 2022/1/19  10:58
 */
public class Partition {
    LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;


        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                /* insert node at head */
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        assert tail != null;
        tail.next = null;

        //the head has changed, so we need to return it to the user
        return head;
    }
}
