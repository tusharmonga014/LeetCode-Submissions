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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int inRootIdx = map.get(preorder[0]);
        root.left = buildTree_(1, inRootIdx, 0, inRootIdx - 1, preorder, inorder, map);
        root.right = buildTree_(1 + inRootIdx, preorder.length - 1, inRootIdx + 1, inorder.length - 1, preorder, inorder, map);
        return root;
    }
    private TreeNode buildTree_(int ps, int pe, int is, int ie, int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
        if(ps > pe || is > ie) {
            return null;
        }
        if(is == ie) {
            return new TreeNode(inorder[is]);
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int inRootIdx = map.get(preorder[ps]);
        int numsLeft = inRootIdx - is;
        root.left = buildTree_(ps + 1, ps + numsLeft, is, inRootIdx - 1, preorder, inorder, map);
        root.right = buildTree_(ps + numsLeft + 1, pe, inRootIdx + 1, ie, preorder, inorder, map);
        return root;
    }
}