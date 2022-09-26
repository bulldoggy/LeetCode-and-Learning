class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i = nums.length-1; i >= 0; i--) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    if(result < dp[i]) result = dp[i];
                }
            }
        }
        
        return result;
    }
}