class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int[] result = new int[nums.length];
        
        for(int num : nums) {
            rightSum += num;
        }
        
        for(int i = 0; i < nums.length; i++) {
            result[i] += Math.abs(rightSum - (nums[i] * (nums.length - i)));
            result[i] += Math.abs(leftSum - (nums[i] * i));
            
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        
        return result;
    }
}