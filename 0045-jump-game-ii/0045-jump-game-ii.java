class Solution {
    public int jump(int[] nums) {
        int end = nums.length-1;
        int currFurthest = end;
        int jump = 0;
        
        while(end > 0) {
            for(int i = end-1; i >= 0; i--) {
                if(i + nums[i] >= end) currFurthest = i;
            }
            end = currFurthest;
            jump++;
        }
        return jump;
    }
}