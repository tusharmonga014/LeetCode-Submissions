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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        targetSum -= root.val;
        if(root.left == null && root.right == null) {
            List<List<Integer>> ans = new ArrayList<>();
            if(targetSum == 0) {
                List<Integer> base = new ArrayList<>();
                base.add(root.val);
                ans.add(base);
            }
            return ans;
        }
        List<List<Integer>> myAns = new ArrayList<>();
        if(root.left != null) {
            List<List<Integer>> lans = pathSum(root.left, targetSum);
            if(lans.size() > 0) {
                for(int i = 0; i < lans.size(); i++) {
                    List<Integer> smallAns = new ArrayList<>();
                    smallAns.add(root.val);
                    smallAns.addAll(lans.get(i));
                    myAns.add(smallAns);
                }
            }
        }
        if(root.right != null) {
            List<List<Integer>> lans = pathSum(root.right, targetSum);
            if(lans.size() > 0) {
                for(int i = 0; i < lans.size(); i++) {
                    List<Integer> smallAns = new ArrayList<>();
                    smallAns.add(root.val);
                    smallAns.addAll(lans.get(i));
                    myAns.add(smallAns);
                }
            }
        }
        return myAns;
    }
}