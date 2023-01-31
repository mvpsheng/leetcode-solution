/**
 * FileName: CopyRandomList35
 * author: gxs
 * Date: 2022/1/12  10:52
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList35 {
    public Node copyRandomList(Node head) {
        Node res = cloneNodes(head);
        res = connectRandomNodes(res);
        res = reconnectNodes(res);
        return res;
    }
    Node cloneNodes(Node head) {
        Node node = head;
        while (node != null) {
            Node cloned = new Node(node.val);
            cloned.next = node.next;
            cloned.random = null;
            node.next = cloned;
            node = cloned.next;
        }
        return head;
    }
    Node connectRandomNodes(Node head) {
        Node node = head;
        while (node != null) {
            Node cloned = node.next;
            if (node.random != null) {
                cloned.random = node.random.next;
            }
            node = cloned.next;
        }
        return head;
    }
    Node reconnectNodes(Node head) {
        Node node = head;
        Node clonedHead = null;
        Node clonedNode = null;

        if (node != null) {
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        while (node != null) {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }
}
