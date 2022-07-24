class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int i = cost.length - 3; i >= 0; i--) {
            cost[i] = cost[i+1] <  cost[i+2] ? cost[i] + cost[i+1] : cost[i] + cost[i+2];
        }
        return cost[0] < cost[1] ? cost[0] : cost[1];
    }
}