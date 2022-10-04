class Solution {
    List<String> list = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        backtrack(new String(""), n, n*2);      
        return list;
    }
    
    public void backtrack(String str, int openLeft, int n) {
        if(str.length() == n) list.add(str);
        if(openLeft > 0) backtrack(str+"(", openLeft-1, n);
        if(((n/2)-openLeft) > str.length()-((n/2)-openLeft)) backtrack(str+")", openLeft, n);
    }
}