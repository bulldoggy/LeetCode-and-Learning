class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        if(nums.length == 2) return nums[1] > nums[0] ? 2 : 1;
        
        int[] arr = new int[nums.length];
        int result = 0;
        
        arr[0] = 0;
        arr[1] = nums[1] > nums[0] ? 1 : 0;
        
        for(int i = 2; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            
            result = Math.max(result, arr[i]);
        }
        
        return result + 1;
    }
}