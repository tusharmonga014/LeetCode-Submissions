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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        
        ms.push(root);
        
        int level = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while(ms.size() != 0) {
            
            int size = ms.size();
            List<Integer> smallAns = new ArrayList<>();
            
            while(size-- > 0) {
            
                TreeNode top = ms.pop();
                
                smallAns.add(top.val);

                if(level % 2 != 0) {
                    if(top.right != null) cs.push(top.right);
                    if(top.left != null) cs.push(top.left);
                } else {
                    if(top.left != null) cs.push(top.left);
                    if(top.right != null) cs.push(top.right);
                }
            }
            
            ms = cs;
            cs = new Stack<>();
            
            ans.add(smallAns);
            
            level++;
        }
        
        return ans;
    }
}