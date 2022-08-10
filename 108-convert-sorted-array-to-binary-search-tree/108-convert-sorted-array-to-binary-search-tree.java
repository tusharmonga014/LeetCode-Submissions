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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = solve(nums, 0, nums.length - 1);
        return root;
    }
    public TreeNode solve(int[] nums, int i, int j) {
        if(i < 0 || j >= nums.length || i > j) {
            return null;
        }
        if(i == j) {
            return new TreeNode(nums[i]);
        }
        
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = solve(nums, i, mid - 1);
        TreeNode right = solve(nums, mid + 1, j);
        root.left = left;
        root.right = right;
        return root;
    }
}