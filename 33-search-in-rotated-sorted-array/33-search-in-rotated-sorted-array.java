class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int start = 0;
        int end = nums.length-1;
        
        if(nums[start] > nums[end]) {
            int edgePointer = 0;

            while(start <= end) {
                int mid = (start + end) / 2;
                if(nums[mid] > nums[mid+1]) {
                    edgePointer = mid;
                    end = -1;
                } else if(nums[mid] >= nums[0]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(nums[edgePointer]);
            if(target < nums[0]) {
                start = edgePointer+1;
                end = nums.length-1;
            } else {
                start = 0;
                end = edgePointer;
            }
        }
    
        while(start <= end) {
            //System.out.println(nums[start]);
            //System.out.println(nums[end]);
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}