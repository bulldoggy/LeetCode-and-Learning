class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = -10001;
        int currSum = 0;
        
        for(int num : nums) {
            if(currSum >= 0) {
                currSum += num;
            } else {
                currSum = num;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}