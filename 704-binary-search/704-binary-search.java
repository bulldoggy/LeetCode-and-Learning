class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        if(end - start == 0) {
            int result = (nums[0] == target) ? 0 : -1;
            return result;
        }
        
        if(end - start == 1) {
            if(nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;   
            } else {
                return -1;
            }
        }
        
        while(end - start > 1) {
            int curr = ((end + start) / 2);
            if(target == nums[curr]) {
                return curr;
            } else if(target > nums[curr]) {
                start = curr;
            } else {
                end = curr;
            }
        }
        
        if(end - start == 1) {
            if(nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;   
            } else {
                return -1;
            }
        }
        
        return -1;
    }
}