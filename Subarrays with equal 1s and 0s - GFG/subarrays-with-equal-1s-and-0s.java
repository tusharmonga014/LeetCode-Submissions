//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int nums[], int len)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int csum = 0;
        
        map.put(csum, 1);
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) csum--;
            else csum++;
            
            map.put(csum, map.getOrDefault(csum, 0) + 1);
        }
        
        int ans = 0;
        for(int sum : map.keySet()) {
            int n = map.get(sum) - 1;
            ans += (n * (n + 1)) / 2;
        }
        
        return ans;
    }
}


