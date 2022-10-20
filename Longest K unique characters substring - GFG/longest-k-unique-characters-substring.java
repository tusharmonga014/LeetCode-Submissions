//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int ans = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = -1;
        int j = -1;
        
        boolean f1 = true;
        boolean f2 = true;
        
        while(f1 || f2) {
            
            f1 = false;
            f2 = false;
            
            while(i < s.length() - 1) {
                f1 = true;
                
                i++;
                
                char c = s.charAt(i);
                
                map.put(c, map.getOrDefault(c, 0) + 1);
                
                if(map.size() == k) {
                    int len = i - j;
                    ans = Math.max(ans, len);
                } else if(map.size() > k) {
                    break;
                }
            }
            
            while(j < i) {
                f2 = true;
                
                j++;
                
                char c = s.charAt(j);
                
                map.put(c, map.getOrDefault(c, 0) - 1);
                
                if(map.containsKey(c) && map.get(c) <= 0) map.remove(c);
                
                if(map.size() == k) {
                    int len = i - j;
                    ans = Math.max(ans, len);
                    break;
                }
            }
        }
        
        return ans == 0 ? -1 : ans;
    }
}