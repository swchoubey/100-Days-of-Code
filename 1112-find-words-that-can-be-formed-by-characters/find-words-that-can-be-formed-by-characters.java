class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for(int i=0;i<chars.length();i++){
            count[chars.charAt(i)-'a']++;
        }
        int len=0;
        for(String s:words){
            if(canForm(s,count)){
                len+=s.length();
            }
        }
        return len;
    }
    private boolean canForm(String s, int[] count){
        int[] alphabet = new int[26];
        for(int i=0;i<s.length();i++){
            int x = s.charAt(i)-'a';
            alphabet[x]++;
            if(alphabet[x]>count[x])
                return false;
        }
        return true;
    }
}