class Solution {
    public int maxSubArray(int[] arr) {
    int csum = arr[0];
    int osum = arr[0];
    for(int i = 1; i < arr.length; i++) {
      if(csum >= 0) {
        csum += arr[i];
      } else {
        csum = arr[i];
      }

      osum = Math.max(osum, csum);
    }
    return osum;
    }
}