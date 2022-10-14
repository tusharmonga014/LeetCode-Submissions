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
    public boolean isPalindrome(ListNode head) {
        ListNode t1 = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode t2 = mid.next;
        mid.next = null;
        
        ListNode prev = null;
        ListNode cur = t2;
        ListNode forw = null;
        
        while(cur != null) {
            forw = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forw;
        }
        
        t2 = prev;
        ListNode c1 = t1, c2 = t2;
        
        boolean isPal = true;
        
        while(c2 != null) {
            if(c1.val != c2.val) {
                isPal = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        
        cur = t2;
        prev = null;
        forw = null;
        
        while(cur != null) {
            forw = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forw;
        }
        
        t2 = prev;
        
        mid.next = t2;
        
        return isPal;
    }
}