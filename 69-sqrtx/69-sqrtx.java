class Solution {
    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }
        int li = 1, ri = x / 2;
        int ans = li;
        while(li <= ri) {
            long mid = li - (li / 2) + (ri / 2);
            long sq = mid * mid;
            if(sq > (long)x) {
                ri = (int)mid - 1;
            } else if(sq < (long)x) {
                ans = (int)mid;
                li = (int)mid + 1;
            } else {
                return (int)mid;
            }
        }
        return ans;
    }
}