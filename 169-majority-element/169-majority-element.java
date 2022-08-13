class Solution {
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        
        for(int num : nums) {
            if(count == 0) {
                result = num;
                count++;
            } else {
                count = result == num ? count + 1 : count - 1;
            }
        }
        return result;
    }
}