class Solution {
    public boolean increasingTriplet(int[] nums) {
        int arr[] = new int[3];
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            if(size == 0) {
                arr[size++] = nums[i];
            } else if(nums[i] > arr[size - 1]) {
                arr[size++] = nums[i];
            } else if(nums[i] < arr[size - 1]) {
                if(size == 1) {
                    arr[0] = nums[i];
                } else if(nums[i] < arr[0]) {
                    arr[0] = nums[i];
                } else if(nums[i] > arr[0]) {
                    arr[1] = nums[i];
                }
            }
            if(size == 3) {
                return true;
            }
        }
        return false;
    }
}