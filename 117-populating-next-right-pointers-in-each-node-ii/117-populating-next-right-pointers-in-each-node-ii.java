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
        if(root == null) {
            return null;
        }
                
        Node next = root.next;
        
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
        if(root.right != null) {
            root.right.next = nextForRightChild;
            connect(root.right);
        }
        
        Node nextForLeftChild = root.right != null ? root.right : nextForRightChild;
        if(root.left != null) {
            root.left.next = nextForLeftChild;
            connect(root.left);
        }
        return root;
    }
}