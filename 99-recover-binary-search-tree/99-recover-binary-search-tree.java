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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode cur = root;
        TreeNode pnode = null;
        
        TreeNode n1, n2, pn1;
        n1 = n2 = pn1 = null;
        
        while(cur != null || !st.isEmpty()) {
            while(cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            
            cur = st.pop();
            
            if(pnode != null) {
                if(pnode.val > cur.val && n1 == null) {
                    pn1 = cur;
                    n1 = pnode;
                } else if(pnode.val > cur.val) {
                    n2 = cur;
                }
            }
            
            pnode = cur;
            
            cur = cur.right;
        }
        
        if(n2 == null) {
            n2 = pn1;
        }
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}