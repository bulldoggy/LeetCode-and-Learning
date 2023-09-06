class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        
        while(pos < strs[0].length()) {
            char c = strs[0].charAt(pos);
            
            for(int i = 1; i < strs.length; i++) {
                if(pos >= strs[i].length() || strs[i].charAt(pos) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            pos++;
        }
        
        return sb.toString();
    }
}