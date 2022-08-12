class Solution {
    public int[] sortedSquares(int[] nums) {
        int lowestPos = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) nums[i] *= -1;
            if(nums[i] < nums[lowestPos]) lowestPos = i;
        }
        
        int[] result = new int[nums.length];
        int start = lowestPos - 1;
        int end = lowestPos + 1;
        
        result[0] = nums[lowestPos] * nums[lowestPos];
        for(int i = 1; i < result.length; i++) {
            if(start < 0) {
                result[i] = nums[end] * nums[end];
                end++;
            } else
            if(end > nums.length - 1) {
                result[i] = nums[start] * nums[start];
                start--;
            } else
            if(nums[end] <= nums[start]) {
                result[i] = nums[end] * nums[end];
                end++;
            } else {
                result[i] = nums[start] * nums[start];
                start--;
            }
        }
        return result;
    }
}