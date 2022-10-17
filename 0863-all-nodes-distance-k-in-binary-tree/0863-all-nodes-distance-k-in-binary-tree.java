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
    List<Integer> ans;
    
    public void kDown(TreeNode root, int k, TreeNode pnode) {
        if(root == null || root == pnode) {
            return;
        }
        
        if(k == 0) {
            ans.add(root.val);
        }
        
        kDown(root.left, k - 1, pnode);
        kDown(root.right, k - 1, pnode);
    }
    
    public int kAway2(TreeNode root, TreeNode node, int k) {
        if(root == null) {
            return -1;
        }
        if(root == node) {
            kDown(root, k, null);
            return 1;
        } else {
            int lkd = kAway2(root.left, node, k);
            if(lkd > -1) {
                kDown(root, k - lkd, root.left);
                return lkd + 1;
            }
            int rkd = kAway2(root.right, node, k);
            if(rkd > -1) {
                kDown(root, k - rkd, root.right);
                return rkd + 1;
            }
        }
        return -1;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        kAway2(root, target, k);
        return ans;
    }
}