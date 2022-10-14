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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        } else if(lists.length == 1) {
            return lists[0];
        }
        return mergeKLists_(lists, 0, lists.length - 1);
    }
    public ListNode mergeKLists_(ListNode[] lists, int si, int ei) {
        if(si == ei) {
            return lists[si];
        } else if(si == ei - 1) {
            return mergeTwoLists(lists[si], lists[ei]);
        } else {
            int mid = (si + ei) / 2;
            return mergeTwoLists(mergeKLists_(lists, si, mid), mergeKLists_(lists, mid + 1, ei));
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                prev.next = cur1;
                prev = cur1;
                cur1 = cur1.next;
            } else {
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }
        
        if(cur1 != null) {
            prev.next = cur1;
        }
        
        if(cur2 != null) {
            prev.next = cur2;
        }
        
        return head.next;
    }
}