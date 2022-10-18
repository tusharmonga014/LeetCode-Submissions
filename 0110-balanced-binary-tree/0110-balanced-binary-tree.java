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
    boolean isBal = true;
    public int isBalanced_(TreeNode root) {
        if(root == null) return -1;
        
        int lh = isBalanced_(root.left);
        if(!isBal) return -2;
        
        int rh = isBalanced_(root.right);
        if(!isBal) return -2;
        
        if(Math.abs(lh - rh) > 1) isBal = false;
        
        return Math.max(lh, rh) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        isBalanced_(root);
        return isBal;
    }
}