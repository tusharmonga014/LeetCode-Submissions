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
    
    public ListNode reverse(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode forw = null;
        
        while(cur != null) {
            forw = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forw;
        }
        
        return prev;
    }
    
    public ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode head2 = reverse(mid);
        ListNode t1 = head;
        ListNode t2 = head2;
        boolean isPal = true;
        while(t2 != null) {
            if(t1.val != t2.val) {
                isPal = false;
                break;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        reverse(head2);
        return isPal;
    }
}