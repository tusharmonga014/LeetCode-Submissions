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
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget_(root, k, root);
    }
    
    public boolean findTarget_(TreeNode root, int k, TreeNode oroot) {
        if(root == null) return false;
        if(k - root.val != root.val && find(oroot, k - root.val)) return true;
        return findTarget_(root.left, k, oroot) || findTarget_(root.right, k, oroot);
    }
    
    private boolean find(TreeNode root, int data) {
        if(root == null) return false;
        if(root.val == data) return true;
        if(root.val > data) return find(root.left, data);
        else return find(root.right, data);
    }
}