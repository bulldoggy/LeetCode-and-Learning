class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int ptr = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                swop(nums, ptr, i);
                ptr++;
            }
        }
        
        return nums;
    }
    
    private void swop(int[] arr, int a, int b) {
        if(a == b) {
            return;
        }
        
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}