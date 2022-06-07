class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp1[] = new int[m];
        for(int i = 0; i < m; i++) {
            temp1[i] = nums1[i];
        }
        
        int x = 0;
        int y = 0;
        int z = 0;
        while(x < m && y < n) {
            if(temp1[x] < nums2[y]) {
                nums1[z] = temp1[x];
                x++;
            } else {
                nums1[z] = nums2[y];
                y++;
            }
            z++;
        }
        
        while(x < m) {
            nums1[z] = temp1[x];
            x++;
            z++;
        }
        
        while(y < n) {
            nums1[z] = nums2[y];
            y++;
            z++;
        }
    }
}