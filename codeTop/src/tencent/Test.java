package tencent;

/**
 * FileName: Test
 * author: gxs
 * Date: 2022/3/15  17:07
 */
public class Test {
    public static void main(String[] args) {
        DListNode n1 = new DListNode(1, 1);
        DListNode n2 = new DListNode(2, 1);
        DListNode n3 = new DListNode(3, 1);
        n1.next = n3;
        n3.pre = n1;
        n3.pre.next = n2;
        n2.pre = n3.pre;
        n2.next = n3;
        n3.pre = n2;
        System.out.println(n3.pre.getKey());
    }
}
