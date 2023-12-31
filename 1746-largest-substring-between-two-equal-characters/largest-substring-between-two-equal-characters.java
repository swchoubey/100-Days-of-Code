class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            int last = s.lastIndexOf(s.charAt(i));
            max = Math.max(max, last-i);
        }
        return (max==0)?-1:max-1;
    }
}