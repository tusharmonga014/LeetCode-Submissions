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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> al = new ArrayList<>();
        helper(root, al);
        
        TreeNode newRoot = al.get(0);
        newRoot.left = null;
        newRoot.right = null;
        TreeNode node = newRoot;
        for(int i = 1; i < al.size(); i++) {
            TreeNode newNode = al.get(i);
            newNode.left = null;
            newNode.right = null;
            node.right = newNode;
            node = newNode;
        }
        
        return newRoot;
    }
    
    public void helper(TreeNode root, ArrayList<TreeNode> al) {
        if(root == null) {
            return;
        }
        
        helper(root.left, al);
        al.add(root);
        helper(root.right, al);
    }
}