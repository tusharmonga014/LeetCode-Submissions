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
    public int pseudoPalindromicPaths (TreeNode root) {
        return solve(root, new HashSet<>());
    }
    private int solve(TreeNode root, HashSet<Integer> set) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            if(set.size() == 0 || (set.size() <= 2 && set.contains(root.val)))
                return 1;
            return 0;
        }
        boolean added = false;
        if(set.contains(root.val)) {
            set.remove(root.val);
        } else {
            set.add(root.val);
            added = true;
        }
        int myAns = solve(root.left, set) + solve(root.right, set);
        if(added) {
            set.remove(root.val);
        } else {
            set.add(root.val);
        }
        return myAns;
    }
}