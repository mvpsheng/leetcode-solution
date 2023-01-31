package linkedlist;

import java.util.Stack;

/**
 * FileName: IsPalindrome
 * author: gxs
 * Date: 2022/1/19  10:38
 */
//Implement a function to check if a linked list is a palindrome
//don't forget import statements!
public class IsPalindrome {
    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        /* push elements from first half of linked list onto stack.
         * When fast runner (which is moving at 2x speed) reaches the
         * end of the linked list, then we know we're at the middle */
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        /*has odd number of elements, so skip the middle element */
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();
            /* if values are different, then it's not a palindrome */
            if (top != slow.data) return false;

            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node5 = new LinkedListNode(2);
        LinkedListNode node6 = new LinkedListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        node5.next = node6;
        node6.next = null;
        System.out.println(new IsPalindrome().isPalindrome(node1));
    }
}
