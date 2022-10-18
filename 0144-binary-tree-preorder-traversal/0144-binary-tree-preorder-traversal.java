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
    class Tpair {
        TreeNode node;
        int state;
        Tpair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Tpair> st = new Stack<>();
        st.push(new Tpair(root, -1));
        while(st.size() != 0) {
            Tpair top = st.peek();
            if(top.state == -1) {
                ans.add(top.node.val);
                if(top.node.left != null) {
                    st.push(new Tpair(top.node.left, -1));
                }
                top.state++;
            } else if(top.state == 0) {
                if(top.node.right != null) {
                    st.push(new Tpair(top.node.right, -1));
                }
                top.state++;
            } else {
                st.pop();
            }
        }
        
        return ans;
    }
}