class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int start = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int currMax = findMaxProduct(nums, start, i - 1);
                if(currMax > result) result = currMax;
                while(i < nums.length && nums[i] == 0) {
                    i++;
                }
                start = i;
                i--;
            }    
        }
        int currMax = findMaxProduct(nums, start, nums.length - 1);
        if(currMax > result) result = currMax;
        return result < 0 && start != 0 ? 0 : result;
    }
    
    private int findMaxProduct(int[] nums, int start, int end) {
        if(start == end) return nums[start];
        int max = Integer.MIN_VALUE;
        int product = 1;
        int firstNegative = -1;
        
        for(int i = start; i <= end; i++) {
            product *= nums[i];
            if(product < 0 && firstNegative == -1) {
                firstNegative = i;
            } else  {
                if(product > max) max = product;
            }
        }
        
        if(product < 0) {
            product = 1;
            for(int i = firstNegative + 1; i <= end; i++) {
                product *= nums[i];
            }
            if(product > max) max = product;
        } 
        return max;
    }
}