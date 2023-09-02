class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for(int value = 1; value <= amount; value++) {
            int min = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(coin <= value && dp[value - coin] != Integer.MAX_VALUE) {
                    min = Math.min(min, dp[value - coin] + 1);  
                }
            }
            dp[value] = min;
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}