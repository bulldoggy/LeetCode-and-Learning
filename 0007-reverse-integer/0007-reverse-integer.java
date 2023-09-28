class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        Long longVal = Long.valueOf(x);
        Long reversedLongVal = 0L;
        
        if(longVal < 0) {
            isNegative = true;
            longVal = -longVal;
        }

        while(longVal > 0) {
            reversedLongVal *= 10;
            reversedLongVal += longVal % 10;
            longVal /= 10;
        }
        
        if(isNegative) {
            if(reversedLongVal > 2147483648L) {
                return 0;   
            } 
            return 0 - reversedLongVal.intValue();
        } 
        
        if(reversedLongVal > 2147483647L) {
            return 0;
        }
        return reversedLongVal.intValue();   
    }
}