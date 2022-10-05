class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        if(nums[start] <= nums[end]) return nums[0];
        while(start <= end) {
            System.out.println("start:"+start+",end:"+end);
            int mid = (start+end)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if(mid == 0 || nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}