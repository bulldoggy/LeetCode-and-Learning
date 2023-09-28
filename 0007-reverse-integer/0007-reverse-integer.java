class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        Long tempX = Long.valueOf(x);
        
        if(tempX < 0) {
            isNegative = true;
            tempX = -tempX;
        }

        Long longVal = Long.valueOf(reverseString(String.valueOf(tempX)));
        
        if((isNegative && longVal > 2147483648L) || (!isNegative && longVal > 2147483647L)) {
            return 0;   
        } 
        
        if(isNegative) {
            return 0 - longVal.intValue();
        }
        return longVal.intValue();   
    }
    
    private String reverseString(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        
        while(start < end) {
            swop(arr, start, end);
            start++;
            end--;
        }
        
        return String.valueOf(arr);
    }
    
    private void swop(char[] arr, int start, int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}