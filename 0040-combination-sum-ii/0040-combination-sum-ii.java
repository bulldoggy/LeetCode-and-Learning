class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), result);
        
        return result;
    }
    
    private void backtrack(int index, 
                           int[] candidates, 
                           int target,
                           List<Integer> curr, 
                           List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
        } else if(target < 0) {
            return;
        } else {
            for(int i = index; i < candidates.length; i++) {
                if(i <= index || candidates[i] != candidates[i - 1]) {
                    curr.add(candidates[i]);
                    backtrack(i + 1, candidates, target - candidates[i], curr, result);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}