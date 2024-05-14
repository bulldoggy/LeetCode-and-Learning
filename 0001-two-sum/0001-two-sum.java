class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(hm.containsKey(nums[i])) {
                List<Integer> list = hm.get(nums[i]);
                list.add(i);
                hm.put(nums[i], list);
            } else {
                hm.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(hm.containsKey(target - nums[i])) {
                List<Integer> list = hm.get(target - nums[i]);
                
                for(int pos : list) {
                    if(i != pos) {
                        return new int[]{i, pos};
                    }
                }
            }
        }
        
        return new int[]{-1, -1};
    }
}