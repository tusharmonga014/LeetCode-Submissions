class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        
        if(b.length < a.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        
        int lo = 0;
        int hi = a.length;
        
        int te = a.length + b.length;
        
        while(lo <= hi) {
            
            int mida = (lo + hi) / 2;
            int midb = ((te + 1) / 2) - mida;
            
            int amid = mida == a.length ? Integer.MAX_VALUE : a[mida];
            int amid_1 = mida == 0 ? Integer.MIN_VALUE : a[mida - 1];
            
            int bmid = midb == b.length ? Integer.MAX_VALUE : b[midb];
            int bmid_1 = midb == 0 ? Integer.MIN_VALUE : b[midb - 1];
            
            if(amid_1 <= bmid && bmid_1 <= amid) {
                
                double median = 0;
                
                if(te % 2 == 0) {
                    median = (Math.max(amid_1, bmid_1) + Math.min(amid, bmid)) / 2.0;
                } else {
                    median = Math.max(amid_1, bmid_1);
                }
                
                return median;
                
            } else if(amid_1 > bmid) {  
                // less elements required from Ist array.
                hi = mida - 1;
            } else {
                // more elements required from Ist array.
                lo = mida + 1;
            }
        }
        
        return 0;
    }
}