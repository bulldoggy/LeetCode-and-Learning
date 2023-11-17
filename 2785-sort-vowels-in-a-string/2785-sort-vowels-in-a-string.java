class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        List<Integer> list = new LinkedList<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> a - b);
        HashSet<Character> dict = new HashSet<>();
        
        dict.add('a');
        dict.add('e');
        dict.add('i');
        dict.add('o');
        dict.add('u');
        dict.add('A');
        dict.add('E');
        dict.add('I');
        dict.add('O');
        dict.add('U');
        
        for(int i = 0; i < arr.length; i++) {
            if(dict.contains(arr[i])) {
                list.add(i);
                pq.add(arr[i]);
            }
        }
        
        for(int pos : list) {
            arr[pos] = pq.poll();
        }
        
        return String.valueOf(arr);
    }
}