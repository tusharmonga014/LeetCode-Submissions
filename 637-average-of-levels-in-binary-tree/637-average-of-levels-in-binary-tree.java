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
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        que.addLast(root);
        while(que.size() > 0) {
            int size = que.size();
            double sum = 0;
            int sz = size;
            while(size-- > 0) {
                TreeNode rem = que.removeFirst();
                if(rem.left != null) que.addLast(rem.left);
                if(rem.right != null) que.addLast(rem.right);
                sum += rem.val;
            }
            double smallAns = sum / sz;
            ans.add(smallAns);
        }
        return ans;
    }
}