class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;             // if 0 or negative
        if((n & (n - 1)) != 0) return false; // not a power of 2
        int zerosBeforeMSB = 0;
        while(n > 0) {
            n = n >> 1;
            zerosBeforeMSB++;
        }
        if(zerosBeforeMSB % 2 != 0) return true;
        else return false;
    }
}