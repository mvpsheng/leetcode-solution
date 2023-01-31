package hot;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * FileName: ReverseList206
 * author: gxs
 * Date: 2022/3/15  15:12
 */
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
//        递归版本
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode res = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return res;

//        使用栈结构
//        Deque<ListNode> stack = new ArrayDeque<>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//        if (stack.isEmpty()) return null;
//        ListNode res = new ListNode(0);
//        ListNode node = res;
//        while (!stack.isEmpty()) {
//            res.next = stack.pop();
//            res = res.next;
//        }
//        res.next = null;
//        return node.next;
//
//        使用双向链表
        ListNode newHead = null;
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode next = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
//            重新赋值原链表头
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(new ReverseList206().reverseList(n1).val);
    }
}
