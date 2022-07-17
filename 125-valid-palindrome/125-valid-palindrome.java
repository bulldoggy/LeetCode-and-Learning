class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        
        while(start < end) {
            while(!isLetterOrNumber(s.charAt(start)) && start < s.length()-1) {
                start++;
            }
            
            while(!isLetterOrNumber(s.charAt(end)) && end > 0) {
                end--;
            }
            
            if(!(toLowerCase(s.charAt(start)) == (toLowerCase(s.charAt(end)))) && start < end) {
                return false;
            }            
            start++;
            end--;
        }
        return true;
    }
    
    public boolean isLetterOrNumber(char c) {
        int cASCII = (int)c;
        
        if((cASCII >= 48 && cASCII <= 57)||(cASCII >= 65 && cASCII <= 90)||(cASCII >= 97 && cASCII <= 122)) {
            return true;  
        }
        return false;
    }
    
    public char toLowerCase(char c) {
        int cASCII = (int)c;
        
        if(cASCII >= 65 && cASCII <= 90) { 
            return (char)(cASCII + 32);
        }
        return c;
    }
}