class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int i:nums) {
            if(!hs.add(i)) {
                return true;
            }
        }
        return false;
    }
}