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
    public ArrayList<TreeNode> ntrp(TreeNode root, TreeNode node) {
        if(root == null) return new ArrayList<>();
        if(root == node) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        
        ArrayList<TreeNode> lp = ntrp(root.left, node);
        if(lp.size() > 0) {
            lp.add(root);
            return lp;
        }
        
        ArrayList<TreeNode> rp = ntrp(root.right, node);
        if(rp.size() > 0) {
            rp.add(root);
            return rp;
        }
        return new ArrayList<>();
    }
    
    public ArrayList<Integer> kDown(TreeNode root, int k, TreeNode pnode) {
        if(root == null || root == pnode) {
            return new ArrayList<>();
        }
        
        if(k == 0) {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(root.val);
            return base;
        }
        
        ArrayList<Integer> lkd = kDown(root.left, k - 1, pnode);
        ArrayList<Integer> rkd = kDown(root.right, k - 1, pnode);
        
        ArrayList<Integer> myAns = new ArrayList<>();
        myAns.addAll(lkd);
        myAns.addAll(rkd);
        return myAns;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> path = ntrp(root, target);
        
        List<Integer> ans = new ArrayList<>();
        
        int i = 0;
        while(k >= 0 && i < path.size()) {
            ans.addAll(kDown(path.get(i), k, i == 0 ? null : path.get(i - 1)));
            System.out.println(ans);
            i++;
            k--;                       
        }
        
        return ans;
    }
}