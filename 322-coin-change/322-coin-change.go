func coinChange(coins []int, amount int) int {
    sort.Ints(coins)
    dp := make([]int, amount+1)
    dp[0] = 0
    
    for i := 1; i <= amount; i++ {
        var min int = 10001
        for j := len(coins)-1; j >= 0; j-- {
            if coins[j] <= i {
                if min > 1 + dp[i-coins[j]] {
                    min = 1 + dp[i-coins[j]]
                }
            }
        }
        dp[i] = min
    }
    
    if dp[amount] >= 10001 {
        return -1
    }
    return dp[amount]
}