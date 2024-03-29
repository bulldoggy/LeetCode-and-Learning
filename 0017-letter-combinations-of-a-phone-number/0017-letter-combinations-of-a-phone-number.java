class Solution {
    Map<Integer, List<String>> hm = new HashMap<>();
    List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return result;    
        }
        
        hm.put(2, List.of("a", "b", "c"));
        hm.put(3, List.of("d", "e", "f"));
        hm.put(4, List.of("g", "h", "i"));
        hm.put(5, List.of("j", "k", "l"));
        hm.put(6, List.of("m", "n", "o"));
        hm.put(7, List.of("p", "q", "r", "s"));
        hm.put(8, List.of("t", "u", "v"));
        hm.put(9, List.of("w", "x", "y", "z"));
        
        backtrack(0, digits, new StringBuilder());
        return result;
    }
    
    private void backtrack(int i, String digits, StringBuilder sb) {
        if(i == digits.length()) {
            result.add(sb.toString());
        } else {
            int num = Integer.valueOf(String.valueOf(digits.charAt(i)));
            for(String s : hm.get(num)) {
                sb.append(s);
                backtrack(i + 1, digits, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}