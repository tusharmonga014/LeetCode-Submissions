/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p1 = getPath(root, p);
        ArrayList<TreeNode> p2 = getPath(root, q);
        int i = p1.size() - 1;
        int j = p2.size() - 1;
        while(i >= 0 && j >= 0) {
            if(p1.get(i) == p2.get(j)) {
                i--;
                j--;
            } else {
                return p1.get(i + 1);
            }
        }
        if(i >= 0) return p2.get(j + 1);
        else return p1.get(i + 1);
    }
    public ArrayList<TreeNode> getPath(TreeNode root, TreeNode node) {
        if(root == null) {
            return null;
        }
        if(root == node) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(node);
            return base;
        } else {
            ArrayList<TreeNode> pl = getPath(root.left, node);
            if(pl != null) {
                pl.add(root);
                return pl;
            }
            ArrayList<TreeNode> pr = getPath(root.right, node);
            if(pr != null) {
                pr.add(root);
                return pr;
            }
            return null;
        }
    }
}