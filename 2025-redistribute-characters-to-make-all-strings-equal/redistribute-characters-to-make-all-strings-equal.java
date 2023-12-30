class Solution {
    public boolean makeEqual(String[] words) {
        if(words.length==1){
            return true;
        }
        int total = 0;
        for(String word : words){
            total+=word.length();
        }
        if(total%words.length!=0){
            return false;
        }
            int[] map = new int[26];
            for(String word : words){
                for(char c : word.toCharArray()){
                    map[c - 'a']++;
                }
            }
            for(int i : map){
                if(i%words.length != 0){
                    return false;
                }
            }
        return true;
    }
}