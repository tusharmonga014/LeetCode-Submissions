//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    static int length(Node node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
    static Node reverse(Node head) {
        Node prev = null;
        Node cur = head;
        Node forw = null;
        
        while(cur != null) {
            forw = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forw;
        }
        
        return prev;
    }
    static Node subLinkedList(Node l1, Node l2)
    {
        while(l1 != null && l1.next != null && l1.data == 0) l1 = l1.next;
        
        while(l2 != null && l2.next != null && l2.data == 0) l2 = l2.next;
        
        int len1 = length(l1);
        int len2 = length(l2);
        
        if(len1 < len2) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        if(len1 == len2) {
            Node c1 = l1;
            Node c2 = l2;
            
            while(c1 != null) {
                if(c1.data < c2.data) {
                    Node temp = l1;
                    l1 = l2;
                    l2 = temp;
                    break;
                } else if(c1.data > c2.data) {
                    break;
                } else {
                    c1 = c1.next;
                    c2 = c2.next;
                }
            }
        }
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        Node dummy = new Node(-1);
        Node ansItr = dummy;
        
        int borrow = 0;
        while(l1 != null) {
            int diff = l1.data - (l2 == null ? 0 : l2.data) + borrow;
            
            if(diff < 0) {
                borrow = -1;
                diff += 10;
            } else {
                borrow = 0;
            }
            
            ansItr.next = new Node(diff);
            ansItr = ansItr.next;
            
            l1 = l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        Node nhead = reverse(dummy.next);
        
        while(nhead != null && nhead.next != null && nhead.data == 0) {
            nhead = nhead.next;
        }
        
        return nhead;
    }
}