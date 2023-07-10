class Solution {
    List<List<Integer>> result = new LinkedList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, list);
        return result;
    }
    
    private void backtrack(int[] nums, LinkedList<Integer> list) {
        if(list.size() == nums.length) {
            result.add(new ArrayList(list));
        }
        
        for(int num : nums) {
            if(list.contains(num)) continue;
            list.add(num);
            backtrack(nums, list);
            list.removeLast();
        }
    }
}