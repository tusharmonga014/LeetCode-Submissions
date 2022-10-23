class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int lo = 1;
        int hi = position[position.length - 1] - position[0];
        
        int ans = 0;
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if(isPossible(position, mid, m)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(int[] arr, int n, int m) {
        int lastPos = Integer.MIN_VALUE;
        for(int ele : arr) {
            if(ele - n >= lastPos) {
                lastPos = ele;
                m--;
            }
            if(m == 0) break;
        }
        
        return m == 0;
    }
}