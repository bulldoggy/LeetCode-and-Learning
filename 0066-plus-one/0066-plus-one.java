class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 1;
        
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] + carry == 10) {
                list.add(0);
            } else {
                list.add(digits[i] + carry);
                carry = 0;
            }
        }
        
        if(carry == 1) {
            list.add(1);
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(list.size() - 1 - i);
        }
        
        return result;
    }
}