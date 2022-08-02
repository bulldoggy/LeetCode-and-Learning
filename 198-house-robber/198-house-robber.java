class Solution {
    public int rob(int[] nums) {
        int first = 0;
        int second = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int temp = first + nums[i] > second ? first + nums[i] : second;
            first = second;
            second = temp;
        }
        return second;
    }
}