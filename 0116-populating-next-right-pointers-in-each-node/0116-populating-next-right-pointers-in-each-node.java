/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        LinkedList<Node> que = new LinkedList<>();
        
        que.addLast(root);
        
        while(que.size() != 0) {
            int size = que.size();
            while(size-- > 0) {
                Node rem = que.removeFirst();
                
                if(size == 0) {
                    rem.next = null;
                } else {
                    rem.next = que.getFirst();
                }
                
                if(rem.left != null) {
                    que.addLast(rem.left);
                }
                
                if(rem.right != null) {
                    que.addLast(rem.right);
                }
            }
        }
        
        
        return root;
    }
}