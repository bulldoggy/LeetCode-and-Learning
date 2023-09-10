class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findSum(0, curr, 0, result, candidates, target);
        return result;        
    }
    
    private void findSum(int i, List<Integer> curr, int sum, List<List<Integer>> result, int[] candidates, int target) {
        if(sum == target) {
            result.add(new ArrayList<>(curr));
        } else if(sum < target) {
            for(int j = i; j < candidates.length; j++) {
                curr.add(candidates[j]);
                findSum(j, curr, sum + candidates[j], result, candidates, target);
                curr.remove(curr.size() - 1);
            }
        }
    }
}