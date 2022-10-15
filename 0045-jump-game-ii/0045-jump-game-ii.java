class Solution {
    public int jump(int[] nums) {
        int end = nums.length-1;
        int furthest = nums.length-1;
        int jumps = 0;
        
        while(end > 0) {
            for(int i = nums.length-2; i >= 0; i--) {
                if(i + nums[i] >= end && i < furthest) {
                    furthest = i;
                }
            }
            end = furthest;
            jumps++;
        }
        return jumps;
    }
}