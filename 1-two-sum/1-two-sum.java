class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = nums.length-1;
        
        for(int n : nums) {
            list.add(n);
        }
        Arrays.sort(nums);
        while(true) {
            if(nums[start] + nums[end] > target) {
                end--;
            } else if(nums[start] + nums[end] < target) {
                start++;
            } else {
                int first = list.indexOf(nums[start]);
                list.set(first, -1000000001);
                int second = list.indexOf(nums[end]);
                return new int[]{first, second};
            }
        }
    }
}