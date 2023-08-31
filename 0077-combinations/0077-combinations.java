class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backtrack(1, n, k, list);
        
        return result;
    }
    
    private void backtrack(int i, int n, int k, List<Integer> list) {
        if(list.size() == k) {
            result.add(new ArrayList(list));
        } else {
            for(int j = i; j <= n; j++) {
                list.add(j);
                backtrack(j + 1, n, k, list);
                list.remove(list.size() - 1);
            }
        }
    }
}