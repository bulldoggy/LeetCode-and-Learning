class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int res = 100001;
        
        for(int num : nums) {
            sum += num;
        }
        
        int remain = sum - x;
        
        if(remain < 0) {
            return -1;
        }
        
        int first = 0;
        int second = 0;
        int windowSum = nums[0];
        
        if(nums[0] == remain) {
            return nums.length - 1;
        }
        
        while(first < nums.length) {
            if(second == nums.length - 1 || windowSum > remain) {
                windowSum -= nums[first];
                first++;
            } else {
                second++;
                windowSum += nums[second];
            }

            if(windowSum == remain) {
                res = Math.min(res, nums.length - (second + 1 - first));
            }
        }
        
        if(res == 100001) {
            return -1;
        }
        return res;
    }
}