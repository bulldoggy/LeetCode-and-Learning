class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i : nums) {
            if(hm.containsKey(i)) {
                hm.put(i, hm.get(i)+1);
            } else {
                hm.put(i, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for(int i = 0; i < k; i++) {
            result[i] = list.get(list.size()-1-i).getKey();
        }
        return result;
    }
}