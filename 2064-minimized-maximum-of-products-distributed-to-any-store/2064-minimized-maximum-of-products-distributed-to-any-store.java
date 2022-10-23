class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int lo = 1;
        
        int hi = Integer.MIN_VALUE;
        for(int ele : quantities) {
            hi = Math.max(hi, ele);
        }
        
        int ans = 0;
        
        while(lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            
            if(isPossible(quantities, n, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(int[] quantities, int stores, int distributionCount) {

        for(int quantity : quantities) {
            stores -= (quantity / distributionCount);
            if(quantity % distributionCount > 0) stores--;
            if(stores < 0) return false;
        }
        
        return true;
    }
}