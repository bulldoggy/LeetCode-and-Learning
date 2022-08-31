class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            while(i > 0 && i < nums.length && nums[i-1] == nums[i]) {
                i++;
            }
            
            if(i <= nums.length-3 ) {
                for(List<Integer> list : twoSum(nums, i+1, nums.length-1, 0-nums[i])) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], list.get(0), list.get(1))));
                }
            }
        }
        return result;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int start, int end, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        
        while(start < end) {
            if(nums[start] + nums[end] < sum) {
                start++;
            } else if(nums[start] + nums[end] > sum) {
                end--;
            } else {
                if(!result.contains(Arrays.asList(nums[start], nums[end]))) result.add(new ArrayList<>(Arrays.asList(nums[start], nums[end])));
                start++;
                end--;
            }
        }
        return result;
    }
}