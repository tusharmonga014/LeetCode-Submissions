/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null)
            return null;
        ListNode entry = head;
        while(slow != entry) {
            slow = slow.next;
            entry = entry.next;
            if(slow == entry) return slow;
        }
        return head;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        } else if(headA.next == null && headB.next == null) {
            if(headA == headB) return headA;
            else return null;
        } else {
            ListNode cur = headA;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = headA;
            ListNode ip = detectCycle(headB);
            cur.next = null;
            return ip;
        }
    }
}