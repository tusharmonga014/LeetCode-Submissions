class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]) {
                if(bs(matrix[i], target)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean bs(int[] arr, int target) {
        int li = 0;
        int ri = arr.length - 1;
        while(li <= ri) {
            int mid = (li + ri) / 2;
            if(arr[mid] < target) {
                li = mid + 1;
            } else if(arr[mid] > target) {
                ri = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}