class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int step2 = cost[cost.length - 1];
        int step1 = cost[cost.length - 2];
        
        for(int i = cost.length - 3; i >= 0; i--){
            int myCost = Math.min(step1, step2) + cost[i];
            step2 = step1;
            step1 = myCost;
        }
        
        return Math.min(step1, step2);
        
    }
}