class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        Arrays.sort(nums);
        int sum=0,diff=(int)(1e9);
        for(int i=0;i<n;++i){
            int l=i+1;
            int r=n-1;
            while(l<r){
                sum=nums[i]+nums[l]+nums[r];
                if(Math.abs(sum-target)<Math.abs(diff)){
                    diff=Math.abs(sum-target);
                    ans=sum;
                }
                if(sum==target) return sum;
                else if(sum<target) l++;
                else r--;
            }
        }
        return ans;
    }
};