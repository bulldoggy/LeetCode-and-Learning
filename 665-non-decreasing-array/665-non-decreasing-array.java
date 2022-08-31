class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                if((i == 0 || i == nums.length-2 || nums[i] <= nums[i+2] || nums[i-1] <= nums[i+1]) && !modified) {
                   modified = true; 
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}