class Solution {
    public int[] twoSum(int[] arr, int target) {
        int ans[] = new int[2];
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            int sum = arr[i] + arr[j];
            if(sum < target) {
                i++;
            } else if(sum > target) {
                j--;
            } else {
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            }
        }
        return ans;
    }
}