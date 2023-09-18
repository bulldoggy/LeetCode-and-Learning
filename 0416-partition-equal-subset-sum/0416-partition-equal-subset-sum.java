class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        boolean[] dp = new boolean[target];
        dp[0] = true;
        
        for(int num : nums) {
            for(int i = target; i >= num; i--) {
                if(dp[i - num]) {
                    if(i == target) {
                        return true;
                    }
                    dp[i] = true;
                }
            }
        }
        
        return false;
    }
}