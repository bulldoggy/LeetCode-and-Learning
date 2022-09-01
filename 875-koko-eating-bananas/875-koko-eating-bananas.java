class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int result = 1000000001;
        int maxPile = 0;
        
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > maxPile) maxPile = piles[i];
        }
        
        int start = 1;
        int end = maxPile;
        
        while(start <= end) {
            int mid = (start+end)/2;
            System.out.println("start: "+start+", end: "+end+", mid: "+mid);
            int hoursNeeded = getHoursNeeded(piles, mid);
            
            if(hoursNeeded > h) {
                start = mid+1;
            } else {
                if(mid < result) result = mid;
                end = mid-1;
            }
        }
        return result;
    }
    
    private int getHoursNeeded(int[] piles, int speed) {
        int result = 0;
        
        for(int i = 0; i < piles.length; i++) {
            result += piles[i] % speed == 0 ? piles[i] / speed : (piles[i] / speed) + 1;
        }
        System.out.println("Speed: "+speed+", Hours: "+result);
        return result < 0 ? 1000000001 : result;
    }
}