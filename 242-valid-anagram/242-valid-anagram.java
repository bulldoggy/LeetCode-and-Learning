class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCA = s.toCharArray();
        char[] tCA = t.toCharArray();
        Arrays.sort(sCA);
        Arrays.sort(tCA);
        String sSorted = new String(sCA);
        String tSorted = new String(tCA);
        return sSorted.equals(tSorted);
    }
}