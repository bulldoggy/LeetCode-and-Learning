class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int i:nums) {
            if(!hs.contains(i)) {
                hs.add(i);
            } else {
                return true;
            }
        }
        return false;
    }
}