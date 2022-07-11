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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        solve(root, nodes, 1);
        return nodes;
    }
    public void solve(TreeNode root, List<Integer> nodes, int level) {
        if(root == null) {
            return;
        }
        if(nodes.size() < level) {
            nodes.add(root.val);
        }
        solve(root.right, nodes, level + 1);
        solve(root.left, nodes, level + 1);
    }
}