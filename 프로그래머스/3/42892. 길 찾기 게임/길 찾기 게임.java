import java.util.*;

class Solution {
    Node[] lst;
    int[][] answer;
    int n;
    int preIdx, postIdx;
    
    public int[][] solution(int[][] nodeinfo) {
        n = nodeinfo.length;
        lst = new Node[n];
        for (int i = 0; i < nodeinfo.length; i++) {
            lst[i] = new Node(nodeinfo[i][1], nodeinfo[i][0], i + 1);
        }
        Arrays.sort(lst);
        Node root = lst[0];
        for (int i = 1; i < n; i++)
            insert(root, lst[i]);
        
        answer = new int[2][n];
        preIdx = 0; postIdx = 0;
        preorder(root);
        postorder(root);
        return answer;
    }
    
    void insert(Node par, Node now) {
        if (par.x > now.x) {
            if (par.left == null)
                par.left = now;
            else
                insert(par.left, now);
        } else {
            if (par.right == null) 
                par.right = now;
            else
                insert(par.right, now);
        }
    }
    
    void preorder(Node node) {
        answer[0][preIdx++] = node.index;
        if (node.left != null)
            preorder(node.left);
        if (node.right != null)
            preorder(node.right);
    }
    
    void postorder(Node node) {
        if (node.left != null)
            postorder(node.left);
        if (node.right != null)
            postorder(node.right);
        answer[1][postIdx++] = node.index;
    }
}

class Node implements Comparable<Node> {
    int y, x, index;
    Node left, right;
    
    Node(int y, int x, int index) {
        this.y = y;
        this.x = x;
        this.index = index;
    }
    
    @Override
    public int compareTo(Node o) {
        if (this.y != o.y)
            return o.y - this.y;
        return this.x - o.x;
    }
}