/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    ArrayList<Integer> tree;
    int pointer;
    
    public BSTIterator(TreeNode root) {
        this.pointer = -1;
        this.tree = new ArrayList<>();
        fillTree(root);
    }
    
    public void fillTree(TreeNode root) {
        if(root == null)
            return;
        fillTree(root.left);
        this.tree.add(root.val);
        fillTree(root.right);
    }
    
    public int next() {
        return tree.get(++pointer);
    }
    
    public boolean hasNext() {
        return pointer + 1 < tree.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */