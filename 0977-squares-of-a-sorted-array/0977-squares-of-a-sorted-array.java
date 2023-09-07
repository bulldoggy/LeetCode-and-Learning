class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int resPos = result.length - 1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            if(Math.abs(nums[start]) > Math.abs(nums[end])) {
                result[resPos] = (int) Math.pow(nums[start], 2);
                start++;
            } else {
                result[resPos] = (int) Math.pow(nums[end], 2);
                end--;
            }
            resPos--;
        }
        
        return result;
    }
}