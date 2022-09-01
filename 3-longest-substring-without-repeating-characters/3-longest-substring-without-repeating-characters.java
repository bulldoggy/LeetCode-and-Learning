class Solution {
    public int lengthOfLongestSubstring(String s) {
        String str = "";
        int first = 0;
        int second = 0;
        int result = 0;
        
        while(second < s.length()) {
            System.out.println(str);
            Character c = s.charAt(second);
            int pos = str.indexOf(c);
            
            if(pos == -1) {
                str += c;
                second++;
            } else {
                if(str.length() > result) result = str.length();
                first += pos+1;
                str = str.substring(pos+1);
            }
        }
        if(str.length() > result) result = str.length();
        return result;
    }
}