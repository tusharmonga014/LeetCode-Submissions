class Solution {
    public int[] sumZero(int n) {
        int ans[] = new int[n];
        int idx = 0;
        if((n & 1) == 1) {
            idx++;
            n--;
        }
        int ele = 1;
        for(int i = 0; i < n / 2; i++) {
            ans[idx++] = ele;
            ans[idx++] = -ele;
            ele++;
        }
        return ans;
    }
}