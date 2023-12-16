class Solution {
    public boolean isAnagram(String s, String t) {
        char[] orig = s.toCharArray();
        char[] comp = t.toCharArray();
        Arrays.sort(orig);
        Arrays.sort(comp);
        String sortO = String.valueOf(orig);
        String sortC = String.valueOf(comp);
        
        return sortO.equals(sortC);
    }
}