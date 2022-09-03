class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(List.of(List.of(), List.of(nums[0])));

        for(int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>(result);
            
            for(List<Integer> list : result) {
                List<Integer> cloned = new ArrayList<>(list);
                cloned.add(nums[i]);
                temp.add(cloned);
            }
            result = temp;
        }
        
        return result;
    }
}