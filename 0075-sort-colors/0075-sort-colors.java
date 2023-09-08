class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pos = 0;
        
        while(pos <= right) {
            if(nums[pos] == 0) {
                int temp = nums[left];
                nums[left] = nums[pos];
                nums[pos] = temp;
                pos++;
                left++;
            } else if(nums[pos] == 2) {
                int temp = nums[right];
                nums[right] = nums[pos];
                nums[pos] = temp;
                right--;
            } else {
                pos++;
            }
        }
    }
}