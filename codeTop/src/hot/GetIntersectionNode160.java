package hot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * FileName: GetIntersectionNode160
 * author: gxs
 * Date: 2021/10/10  19:24
 */
public class GetIntersectionNode160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode fakeHead = headA;
//        if (headA == null || headB == null) {
//            return null;
//        }
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int count = 0;
//        while (fakeHead != null) {
//            map.put(fakeHead.val,count++);
//            fakeHead = fakeHead.next;
//        }
//        fakeHead = headB;
//        int countB = 1;
//        while (fakeHead != null) {
//           if (map.containsKey(fakeHead.val)) {
//               break;
//           }
//           countB++;
//            fakeHead = fakeHead.next;
//        }
//        fakeHead = headA;
//        for (int i = 0; i < countB; i++) {
//            fakeHead = fakeHead.next;
//        }
//        return fakeHead;

//        方法一：哈希集合  当下一个扫描到相同的时候直接返回当前节点
        Set<ListNode> visited = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            visited.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if (visited.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;

//        方法二：双指针
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode pA = headA, pB = headB;
//        while (pA != pB) {
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
//        }
//        return pA;

    }

    public static void main(String[] args) {
//        listA = [4,1,8,4,5], listB = [5,0,1,8,4,5],
        ListNode L1 = new ListNode(4);
        ListNode L2 = new ListNode(1);
        ListNode L3 = new ListNode(8);
        ListNode L4 = new ListNode(4);
        ListNode L5 = new ListNode(5);
        ListNode L11 = new ListNode(5);
        ListNode L12 = new ListNode(0);
        ListNode L13 = new ListNode(1);
        ListNode L14 = new ListNode(8);
        ListNode L15 = new ListNode(4);
        ListNode L16 = new ListNode(5);
        L1.next = L2;
        L2.next = L3;
        L3.next = L4;
        L4.next = L5;
        L5.next = null;
        L11.next = L12;
        L12.next = L13;
        L13.next = L14;
        L14.next = L15;
        L15.next = L16;
        L16.next = null;
        ListNode res = getIntersectionNode(L1,L11);
        System.out.println(res);
    }
}
