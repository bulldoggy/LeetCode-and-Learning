class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder longer;
        StringBuilder shorter;
        StringBuilder result = new StringBuilder();
        
        if(a.length() > b.length()) {
            longer = new StringBuilder(a);
            shorter = new StringBuilder(b);
        } else {
            longer = new StringBuilder(b);
            shorter = new StringBuilder(a);
        }
        
        longer.reverse();
        shorter.reverse();
        int l = 0;
        int s = 0;
        
        for(int i = 0; i < longer.length(); i++) {
            if(i >= shorter.length() || shorter.charAt(i) == '0') {
                s = 0;
            } else {
                s = 1;
            }
            if(longer.charAt(i) == '0') {
                l = 0;
            } else {
                l = 1;
            }
        
            int val = carry + l + s;
            
            if(val == 3) {
                result.append("1");
                carry = 1;
            } else if(val == 2) {
                result.append("0");
                carry = 1;
            } else {
                result.append(String.valueOf(val));
                carry = 0;
            }
        }
        
        if(carry == 1) {
            result.append("1");
        }
        
        return result.reverse().toString();
    }
}