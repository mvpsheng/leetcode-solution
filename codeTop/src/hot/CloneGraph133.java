package hot;

import java.util.*;

/**
 * FileName: CloneGraph133
 * author: gxs
 * Date: 2021/11/27  9:49
 */
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph133 {
/**
 * 深度优先遍历，找到当前节点的所有neighbors并返回clone，然后再去找
 * neighbors的neighbors返回clone,就是所有节点的clone;
 */
    public Node cloneGraph(Node node) {
        Map<Node,Node> map = new HashMap<>();
        return dfs(node,map);
    }
    private Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node,clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n,map));
        }
        return clone;
    }
/**
 * 广度优先搜索遍历,用一个队列
 * 判断当前节点的邻居有没有加入到map中,如果没有就加入,并将其加入队列中
 * 队列出队,做上一步同样的操作,如果map包含了当前节点的邻居,
 * 就将当前节点的邻居的克隆,加入当前节点的克隆的邻居中.
 * 队列为空时,返回克隆
 * */
//    public Node cloneGraph(Node node) {
//        if (node == null) {
//            return null;
//        }
////        map用来保存当前节点和其克隆
//        Map<Node, Node> map = new HashMap<>();
//        Node clone = new Node(node.val, new ArrayList<>());
//        map.put(node,clone);
//        Deque<Node> queue = new LinkedList<>();
//        queue.offer(node);
//        while (!queue.isEmpty()) {
//            Node tmp = queue.poll();
//            for (Node n : tmp.neighbors) {
//                if (!map.containsKey(n)) {
//                    map.put(n, new Node(n.val, new ArrayList<>()));
//                    queue.offer(n);
//                }
//                map.get(tmp).neighbors.add(map.get(n));
//            }
//        }
//        return clone;
//    }
}
