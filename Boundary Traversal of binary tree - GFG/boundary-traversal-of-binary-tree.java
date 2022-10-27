//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    
    private void leftBT(Node node, ArrayList<Integer> l) {
        if(node == null || (node.left == null && node.right == null)) return;
        l.add(node.data);
        if(node.left != null) {
            leftBT(node.left, l);
        } else {
            leftBT(node.right, l);
        }
    }
    private void leafBT(Node node, ArrayList<Integer> lf) {
        if(node == null) return;
        if(node.left == null && node.right == null)
            lf.add(node.data);
        leafBT(node.left, lf);
        leafBT(node.right, lf);
    }
    private void rightBT(Node node, ArrayList<Integer> r) {
        if(node == null || (node.left == null && node.right == null)) return;
        if(node.right != null) {
            rightBT(node.right, r);
        } else {
            rightBT(node.left, r);
        }
         r.add(node.data);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    if(node == null) return new ArrayList<>();
	    ArrayList<Integer> l = new ArrayList<>();
	    ArrayList<Integer> lf = new ArrayList<>();
	    ArrayList<Integer> r = new ArrayList<>();
	    leftBT(node.left, l);
	    leafBT(node.left, lf);
	    leafBT(node.right, lf);
	    rightBT(node.right, r);
	    ArrayList<Integer> ans = new ArrayList<>();
	    ans.add(node.data);
	    ans.addAll(l);
	    ans.addAll(lf);
	    ans.addAll(r);
	    return ans;
	}
}
