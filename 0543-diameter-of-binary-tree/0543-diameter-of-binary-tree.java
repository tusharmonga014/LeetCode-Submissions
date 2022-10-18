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
    private int calcDia_returnMaxH(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 0;
        } else if(root.left == null) {
            int rh = calcDia_returnMaxH(root.right) + 1;
            maxDia = Math.max(maxDia, rh);
            return rh;
        } else if(root.right == null) {
            int lh = calcDia_returnMaxH(root.left) + 1;
            maxDia = Math.max(maxDia, lh);
            return lh;
        } else {
            int lh = calcDia_returnMaxH(root.left) + 1;
            int rh = calcDia_returnMaxH(root.right) + 1;
            maxDia = Math.max(maxDia, lh + rh);
            return Math.max(lh, rh);
        }
    }
    private int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calcDia_returnMaxH(root);
        return maxDia;
    }
}