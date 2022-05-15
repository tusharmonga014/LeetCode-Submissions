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
    public int deepestLeavesSum(TreeNode root) {
        int hei = height(root);
        int sum = helper(root, hei);
        return sum;
    }
    
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHei = height(root.left);
        int rightHei = height(root.right);
        return Math.max(leftHei, rightHei) + 1;
    }
    
    private int helper(TreeNode root, int hei) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null && hei == 1) {
            return root.val;
        }
        int left = helper(root.left, hei - 1);
        int right = helper(root.right, hei - 1);
        return left + right;
    }
}