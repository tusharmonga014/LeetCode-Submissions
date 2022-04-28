class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k == 1) {
            return kadanes(arr);
        } else {
            long sum = 0;
            int M = (int)(1e9) + 7;
            for(int ele : arr) {
                sum += ele;
            }
            
            int narr[] = new int[arr.length * 2];
            
            int fillIdx = 0;
            for(int ele : arr) {
                narr[fillIdx++] = ele;
            }
            for(int ele : arr) {
                narr[fillIdx++] = ele;
            }
            
            if(sum < 0) {
                return kadanes(narr);
            } else {
                return (int)((kadanes(narr) + ((k - 2) * sum)) % M);
            }
        }
    }
    
    public int kadanes(int[] arr) {
        long csum = 0;
        long osum = 0;
        
        long M = (int)(1e9) + 7;
        
        for(int i = 0; i < arr.length; i++) {
            if(csum >= 0) {
                csum += arr[i];
            } else {
                csum = arr[i];
            }
            
            osum = Math.max(osum, csum);
        }
        
        return (int)(osum % M);
    }
}