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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        
        int carry = 0;
        while(carry > 0 || l1 != null || l2 != null) {
            int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            int toAdd = sum % 10;
            carry = sum / 10;
            ListNode addNode = new ListNode(toAdd);
            ans.next = addNode;
            ans = ans.next;
            
            l1 = l1 == null ? null :  l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        return dummy.next;
    }
}