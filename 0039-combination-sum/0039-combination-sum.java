class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, new ArrayList<>(), candidates, target, 0, 0);
        
        return result;
    }
    
    private void backtrack(
        List<List<Integer>> result, 
        List<Integer> list, 
        int[] candidates, 
        int target, 
        int pos,
        int sum
    ) {
        if(pos >= candidates.length) return;

        System.out.println(list.toString() + ", pos: " + pos);       

        if(sum > target) return;
        
        if(sum == target) {
            System.out.println("added " + list.toString());
            result.add(list);
            return;
        }
        
        int curr = candidates[pos];  
        List<Integer> chosen = new ArrayList<>(list);
        chosen.add(curr);
        List<Integer> notChosen = new ArrayList<>(list);
        
        backtrack(result, chosen, candidates, target, pos, sum + curr);
        backtrack(result, notChosen, candidates, target, pos + 1, sum);
    }
}