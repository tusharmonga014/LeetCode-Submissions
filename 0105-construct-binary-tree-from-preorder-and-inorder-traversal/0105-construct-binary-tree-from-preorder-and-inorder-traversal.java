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
        TreeNode root = bt(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
        return root;
    }
    
    public TreeNode bt(int[] preorder, int[] inorder, int ps, int pe, int is, int ie, HashMap<Integer, Integer> map) {
        if(is > ie || ps > pe) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[ps]);
        int countOfElementsOnLeft = map.get(preorder[ps]) - is;
        
        root.left = bt(preorder, inorder, ps + 1, ps + countOfElementsOnLeft, is, is + countOfElementsOnLeft - 1, map);
        
        root.right = bt(preorder, inorder, ps + countOfElementsOnLeft + 1, pe, is + countOfElementsOnLeft + 1, ie, map);
        
        return root;
    }
}