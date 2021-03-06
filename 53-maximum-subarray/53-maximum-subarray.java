class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > sum + nums[i]) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            
            if(sum > result) {
                result = sum;
            }
        }
        
        return result;
    }
}