//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class GfG
{
    public static Node[] segregate(Node head) {
        if(head == null || head.next == null)
            return new Node[]{null, head, null};
        
        Node sLL = new Node(-1);
        Node gLL = new Node(-1);
        
        Node si = sLL;
        Node gi = gLL;
        
        Node pivot = head;
        while(pivot.next != null)
            pivot = pivot.next;
        
        Node cur = head;
        while(cur != null) {
            if(cur != pivot) {
                if(cur.data <= pivot.data) {
                    si.next = cur;
                    si = si.next;
                } else {
                    gi.next = cur;
                    gi = gi.next;
                }
            }
        
            Node forw = cur.next;
            cur.next = null;
            cur = forw;
        }
        
        return new Node[]{sLL.next, pivot, gLL.next};
    }
    public static Node quickSort(Node node)
    {
        if(node == null || node.next == null)
            return node;
            
        Node nodes[] = segregate(node);
        nodes[0] = quickSort(nodes[0]);
        nodes[2] = quickSort(nodes[2]);
        
        Node tail1 = nodes[0];
        while(tail1 != null && tail1.next != null) {
            tail1 = tail1.next;
        }
        
        nodes[1].next = nodes[2];
        
        if(tail1 != null) {
            tail1.next = nodes[1];
            return nodes[0];
        } else {
            return nodes[1];
        }
    }
    
    
}