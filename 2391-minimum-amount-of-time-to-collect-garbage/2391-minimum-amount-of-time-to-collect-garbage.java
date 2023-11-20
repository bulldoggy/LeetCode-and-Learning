class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalGarbage = 0;
        int furthestM = -1;
        int furthestP = -1;
        int furthestG = -1;
        
        int pos = garbage.length - 1;
        
        while(pos > 0 && (furthestM == -1 || furthestP == -1 || furthestG == -1)) {
            String currGarbage = garbage[pos];
            
            if(furthestM == -1 && currGarbage.contains("M")) {
                furthestM = pos;   
            }
            
            if(furthestP == -1 && currGarbage.contains("P")) {
                furthestP = pos;
            }
            
            if(furthestG == -1 && currGarbage.contains("G")) {
                furthestG = pos;
            }
            
            pos--;
        }
        
        for(int i = 1; i < travel.length; i++) {
            travel[i] += travel[i-1];
        }
        
        for(String str : garbage) {
            totalGarbage += str.length();
        }
                
        return totalGarbage 
            + (furthestM == -1 ? 0 : travel[furthestM - 1]) 
            + (furthestP == -1 ? 0 : travel[furthestP - 1]) 
            + (furthestG == -1 ? 0 : travel[furthestG - 1]);
    }
}