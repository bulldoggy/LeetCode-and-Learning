class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sCA = s.toCharArray();
        char[] tCA = t.toCharArray();
        Arrays.sort(sCA);
        Arrays.sort(tCA);
       
        for(int i = 0; i < sCA.length; i++) {
            if(sCA[i] != tCA[i]) {
                return false;
            }
        }
        return true;
    }
}