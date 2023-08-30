class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            if(nums[0] == target) {
                return 0;
            }    
            return -1;
        }
        
        int start = 0;
        int end  = nums.length-1;
        int edge = 0;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(mid == nums.length-1 || nums[mid] > nums[mid+1]) {
                edge = mid;
                end = -1;
            } else if(nums[mid] < nums[0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(edge == nums.length-1 || target >= nums[0]) {
            start = 0;
            end = edge;
        } else {
            start = edge + 1;
            end = nums.length - 1;
        }
                
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}