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
    public int goodNodes(TreeNode root) {
        return solve(root, root.val);
    }
    private int solve(TreeNode root, int max) {
        if(root == null) {
            return 0;
        }
        int ans = max <= root.val ? 1 : 0;
        max = Math.max(max, root.val);
        ans += solve(root.left, max);
        ans += solve(root.right, max);
        return ans;
    }
}