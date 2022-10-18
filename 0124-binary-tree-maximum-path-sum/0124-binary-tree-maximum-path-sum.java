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
    public int max = Integer.MIN_VALUE;
    public int calcMax(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        }
        
        if(root.left == null) {
            int cs = calcMax(root.right);
            max = Math.max(max, Math.max(root.val, cs + root.val));
            return Math.max(root.val, root.val + cs);
        }
        
        if(root.right == null) {
            int cs = calcMax(root.left);
            max = Math.max(max, Math.max(root.val, cs + root.val));
            return Math.max(root.val, root.val + cs);
        }
        
        int ls = calcMax(root.left);
        int rs = calcMax(root.right);
        max = Math.max(max, Math.max(ls + root.val, Math.max(rs + root.val, Math.max(ls + root.val + rs, root.val))));
        return Math.max(root.val, Math.max(root.val + ls, root.val + rs));
    }
    public int maxPathSum(TreeNode root) {
        calcMax(root);
        return max;
    }
}