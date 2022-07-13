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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        que.add(root);
        
        while(que.size() != 0) {
            
            int size = que.size();
            List<Integer> smallAns = new ArrayList<>();
            
            while(size-- > 0) {
                TreeNode rem = que.removeFirst();
                smallAns.add(rem.val);
                if(rem.left != null) que.addLast(rem.left);
                if(rem.right != null) que.addLast(rem.right);
            }
            
            ans.add(smallAns);
        }
        return ans;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> LO = levelOrder(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = LO.size() - 1; i >= 0; i--) {
            ans.add(LO.get(i));
        }
        return ans;
    }
}