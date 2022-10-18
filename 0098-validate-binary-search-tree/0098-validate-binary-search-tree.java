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
    
    class Pair {
        boolean isBST;
        long min;
        long max;
        Pair(boolean isBST, long min, long max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    
    public Pair isValidBST_(TreeNode root) {
        if(root == null) {
            return new Pair(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }
        
        Pair left = isValidBST_(root.left);
        if(!(left.isBST && root.val > left.max)) return new Pair(false, Long.MIN_VALUE, Long.MAX_VALUE);
        
        Pair right = isValidBST_(root.right);
        if(!(right.isBST && root.val < right.min)) return new Pair(false, Long.MIN_VALUE, Long.MAX_VALUE);
        
        long min = Math.min(root.val, Math.min(left.min, right.min));
        long max = Math.max(root.val, Math.max(left.max, right.max));
        Pair myPair = new Pair(true, min, max);
        
        return myPair;
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST_(root).isBST;
    }
}