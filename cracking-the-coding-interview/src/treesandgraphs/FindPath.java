package treesandgraphs;

import java.util.LinkedList;

/**
 * FileName: FindPath
 * author: gxs
 * Date: 2022/1/19  21:01
 */
/* give a directed graph,
design an algorithm to find out whether
there is a route between two nodes */
class Graph {
    LinkedList<Node> q = new LinkedList<Node>();
    static class Node {
        int data;
        FindPath.State state;
        LinkedList<Node> adjacentNodes;
        public LinkedList<Node> getAdjacent() {
            return adjacentNodes;
        }
    }
    public LinkedList<Node> getNodes() {
        return q;
    }
}
public class FindPath {
    public enum State {
        Unvisited, Visited, Visiting;
    }

    public static boolean search(Graph g, Graph.Node start, Graph.Node end) {
        if (start == end) {
            return true;
        }

        //operates as Queue
        LinkedList<Graph.Node> q = new LinkedList<>();

        for (Graph.Node u: g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        Graph.Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Graph.Node v: u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        }
                        else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
            }
            u.state = State.Visited;
        }
        return false;
    }
}
