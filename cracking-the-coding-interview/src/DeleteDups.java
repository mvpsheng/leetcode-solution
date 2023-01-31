import java.util.HashSet;
import java.util.LinkedList;

/**
 * FileName: DeleteDups
 * author: gxs
 * Date: 2022/1/18  14:22
 */
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
//write code to remove duplicates from an unsorted linked list
public class DeleteDups {
    void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
}
