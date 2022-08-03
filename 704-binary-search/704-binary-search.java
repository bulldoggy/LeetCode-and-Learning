class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(end >= start) {
            int curr = (start + end) / 2;
            if(target == nums[curr]) return curr;
            if(target < nums[curr]) {
                end = curr - 1;
            } else {
                start = curr + 1;
            }
        }
        return -1;
    }
}