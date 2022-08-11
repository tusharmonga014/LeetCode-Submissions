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
    public class BT {
        boolean isBst;
        long max;
        long min;
        BT(boolean isBst, long max, long min) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
        }
    }
    public BT solve(TreeNode root) {
        if(root == null) {
            return new BT(true, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        BT left = solve(root.left);
        if(!left.isBst || left.max >= root.val) {
            return new BT(false, -1, -1);
        }
        BT right = solve(root.right);
        if(!right.isBst || right.min <= root.val) {
            return new BT(false, -1, -1);
        }
        long max = Math.max(root.val, Math.max(left.max, right.max));
        long min = Math.min(root.val, Math.min(left.min, right.min));
        return new BT(true, max, min);
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root).isBst;
    }
}