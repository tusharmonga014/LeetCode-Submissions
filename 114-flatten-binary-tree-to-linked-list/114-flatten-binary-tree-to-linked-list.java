class Solution {
    public void flatten(TreeNode root) {
        linearize(root);
    }
    
    public TreeNode linearize(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        if(root.left == null && root.right == null) {
            return root;
        } else if(root.left == null) {
            return linearize(root.right);
        } else if(root.right == null) {
            root.right = root.left;
            root.left = null;
            return linearize(root.right);
        } else {
            TreeNode tr = root.right;
            TreeNode tail = linearize(root.left);
            root.right = root.left;
            root.left = null;
            tail.right = tr;
            return linearize(tr);
        }
    }
}