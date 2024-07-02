class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        if(nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        for(int num : nums1) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        for(int num : nums2) {
            if(hm.containsKey(num)) {
                list.add(num);
                
                if(hm.get(num) <= 1) {
                    hm.remove(num);
                } else {
                    hm.put(num, hm.get(num) - 1);
                }
            }
        }
        
        return intListToArray(list);
    }
    
    private int[] intListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}