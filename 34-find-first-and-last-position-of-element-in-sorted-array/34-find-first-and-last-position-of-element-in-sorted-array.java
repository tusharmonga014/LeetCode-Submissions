class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        if(lb != -1) {
            int ub = upperBound(nums, target);
            return new int[]{lb, ub};
        }
        return new int[]{-1, -1};
    }
    public int lowerBound(int[] arr, int data) {
        int li = 0;
        int ri = arr.length - 1;
        while(li <= ri) {
            int mid = (li + ri) / 2;
            if(arr[mid] < data) {
                li = mid + 1;
            } else if(arr[mid] > data) {
                ri = mid - 1;
            } else {
                if(mid == 0) {
                    return mid;
                } else {
                    if(arr[mid - 1] == data) {
                        ri = mid - 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
    public int upperBound(int[] arr, int data) {
        int li = 0;
        int ri = arr.length - 1;
        while(li <= ri) {
            int mid = (li + ri) / 2;
            if(arr[mid] < data) {
                li = mid + 1;
            } else if(arr[mid] > data) {
                ri = mid - 1;
            } else {
                if(mid == arr.length - 1) {
                    return mid;
                } else {
                    if(arr[mid + 1] == data) {
                        li = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}