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
    TreeNode node;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode myLeft = root.left;
        TreeNode myRight = root.right;
        flatten(myLeft);
        flatten(myRight);
        TreeNode tail = getTail(myLeft);
        if(tail == null) {
            root.right = myRight;
        } else {
            tail.right = myRight;
            root.right = myLeft;
        }
        root.left = null;
    }
    public TreeNode getTail(TreeNode root) {
        if(root == null || root.right == null) {
            return root;
        }
        return getTail(root.right);
    }
}