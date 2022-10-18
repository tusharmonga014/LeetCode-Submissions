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
    int tilt = 0;
    public int updateTiltReturnSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int ls = updateTiltReturnSum(root.left);
        int rs = updateTiltReturnSum(root.right);
        
        int myTilt = Math.abs(ls - rs);
        tilt += myTilt;
        
        return ls + root.val + rs;
    }
    public int findTilt(TreeNode root) {      
        updateTiltReturnSum(root);
        return tilt;
    }
}