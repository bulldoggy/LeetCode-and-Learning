class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isNeutral = true;
        boolean isIncrease = true;
        int prev = nums[0];
        
        for(int num : nums) {
            if(isNeutral) {
                if(prev != num) {
                    if(prev > num) {
                        isIncrease = false;
                    }
                    isNeutral = false;
                }
            } else {
                if(isIncrease) {
                    if(prev > num) {
                        return false;
                    }
                } else {
                    if(prev < num) {
                        return false;
                    }
                }
            }
            
            prev = num;
        }
        
        return true;
    }
}