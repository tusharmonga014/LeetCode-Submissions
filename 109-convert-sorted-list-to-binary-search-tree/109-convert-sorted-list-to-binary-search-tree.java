/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        return solve(head);
    }
    
    public TreeNode solve(ListNode head) {
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        if(head.next.next == null) {
            TreeNode root = new TreeNode(head.val);
            TreeNode right = new TreeNode(head.next.val);
            root.right = right;
            return root;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null) prev.next = null;
        TreeNode left = solve(head);
        TreeNode right = solve(slow.next);
        TreeNode root = new TreeNode(slow.val, left, right);
        return root;
    }
}