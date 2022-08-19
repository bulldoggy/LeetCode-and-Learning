class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
            
        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        
        for(int i = 1; i < nums.length; i++) {
            arr1[i-1] = nums[i];
        }
        
        for(int i = 0; i < nums.length-1; i++) {
            arr2[i] = nums[i];
        } 
        return Math.max(maxMoney(arr1), maxMoney(arr2));
    }
    
    public int maxMoney(int[] nums) {
        int first = 0;
        int second = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int temp = first + nums[i] > second ? first + nums[i] : second;
            first = second;
            second = temp;
        }
        return second;
    }
}