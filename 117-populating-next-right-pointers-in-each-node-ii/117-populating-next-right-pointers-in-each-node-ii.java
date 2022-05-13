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
        helper(root, null);
        return root;
    }
    
    public void helper(Node root, Node next) {
        if(root == null) {
            return;
        }
        
        root.next = next;
        
        Node nextForRightChild = null;
        while(next != null) {
            if(next.left != null) {
                nextForRightChild = next.left;
                break;
            } else if(next.right != null) {
                nextForRightChild = next.right;
                break;
            } else {
                next = next.next;
            }
        }
        helper(root.right, nextForRightChild);
        
        Node nextForLeftChild = root.right != null ? root.right : nextForRightChild;
        helper(root.left, nextForLeftChild);
    }
}