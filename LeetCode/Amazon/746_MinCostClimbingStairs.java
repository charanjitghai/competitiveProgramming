class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1)
            return cost[0];

        for(int i = cost.length -3; i>=0 ; i--) {
            cost[i] = cost[i] + Math.min(cost[i+1], cost[i+2]);
        }
        
        return Math.min(cost[0], cost[1]);
    }
}