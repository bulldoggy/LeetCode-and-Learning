class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int result = Integer.MIN_VALUE;
        
        for(int num : nums) {
            if(num == 0) {
                max = 1;
                min = 1;
            } 
            
            int temp = max * num;
            max = Math.max(Math.max(max * num, min * num), num);
            min = Math.min(Math.min(temp, min * num), num);
                System.out.println(max + " | " + min);
            result = Math.max(result, max);
            
        }
        
        return result;
    }
}

/*
-2 0 -1
-2 0 -1
*/