package everydayOneQuestion;

/**
 * FileName: MergeInBetween1669
 * author: gxs
 * Date: 2023/1/30  8:18
 */
public class MergeInBetween1669 {
    /**
     * 1. 分析约束条件,
     *      list1的长度大于等于3
     *      list2的长度大于等于1
     *      插入点在list1之间
     * 2. 数据结构和算法
     *      用另外一个节点来作为list1后半段的头节点，之后连接到list2的尾节点之后
     * 3. 算法复杂度
     *      时间复杂度：两个链表都扫描一遍，所以时间复杂度为O(N);
     *      空间复杂度：只需要用到一个节点来存储list1的后半段，所以空间复杂度为O(1)。
     * 4. 核心代码
     *      ListNode halfList1 = new ListNode();
     *      boolean outOfAPair = true;
     * 5. 测试
     *      list1 长度为3，list2 长度为1
     * */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
/**
 * 思路： 先找到list1插入的b节点，然后让a节点之后跟上b，扫描到b的尾巴，让b的尾巴之后跟上list1的后半段
 * */
        ListNode halfTailList1 = list1;
        ListNode halfPreList1 = list1;
        ListNode currentList2Node = list2;
        for (int i = 0; i < b + 1; i++) {
            halfTailList1 = halfTailList1.next;
        }
        for (int i = 1; i < a; i++) {
            halfPreList1 = halfPreList1.next;
        }
        halfPreList1.next = list2;
        while (currentList2Node.next != null) {
            currentList2Node = currentList2Node.next;
        }
        currentList2Node.next = halfTailList1;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(11);
        ListNode list12 = new ListNode(12);
        ListNode list13 = new ListNode(13);
        ListNode list2 = new ListNode(2);
        list1.next = list11;
        list11.next = list12;
        list12.next = list13;
        new MergeInBetween1669().mergeInBetween(list1, 1, 3, list2);
        while (list1 != null) {
            System.out.println(list1.val);
            list1 = list1.next;
        }
    }
}
