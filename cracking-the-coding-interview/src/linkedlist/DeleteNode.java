package linkedlist;

import java.util.LinkedList;

/**
 * FileName: DeleteNode
 * author: gxs
 * Date: 2022/1/18  21:07
 */
//Implement an algorithm to delete a node in the middle of a singly linked list, give only access to that node
class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode() {
    }

    public LinkedListNode(int data) {
        this.data = data;
    }

    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }
}
public class DeleteNode {
    public static boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) return false;

        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

}
