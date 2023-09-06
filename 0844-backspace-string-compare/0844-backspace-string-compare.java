class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sPos = s.length() - 1;
        int tPos = t.length() - 1;
        int sBack = 0;
        int tBack = 0;
        
        while(sPos >= 0 || tPos >= 0) {
            while(sPos >= 0) {
                if(s.charAt(sPos) == '#') {
                    sBack++;
                    sPos--;
                } else if(sBack > 0) {
                    sBack--;
                    sPos--;
                } else {
                    break;
                }
                
            }
            
            while(tPos >= 0) {
                if(t.charAt(tPos) == '#') {
                    tBack++;
                    tPos--;
                } else if(tBack > 0) {
                    tBack--;
                    tPos--;
                } else {
                    break;
                }
                
            }
            
            if(((sPos >= 0) != (tPos >= 0)) || (sPos >= 0 && s.charAt(sPos) != t.charAt(tPos))) {
                return false;
            }
            
            sPos--;
            tPos--;
        }
        
        return true;
    }
}