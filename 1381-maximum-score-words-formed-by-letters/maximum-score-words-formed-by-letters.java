class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        int[] lCount = new int[26];

        for(char c : letters){
            count[c - 'a']++;
        }

        int ans = 0;
        ans = backtrack(words, score, count, lCount, 0, 0, ans);

        return ans;
    }

    private int backtrack(String[] words, int[] score, int[] count, int[] lCount, int pos, int temp, int ans){
        for(int i = 0; i < 26; i++){
            if(lCount[i] > count[i]) return ans;
        }
        ans = Math.max(ans, temp);

        for(int i = pos; i < words.length; i++){
            for(char c : words[i].toCharArray()){
                lCount[c - 'a']++;
                temp += score[c - 'a'];
            }

            ans = backtrack(words, score, count, lCount, i + 1, temp, ans);

            for(char c : words[i].toCharArray()){
                lCount[c - 'a']--;
                temp -= score[c - 'a'];
            }
        }

        return ans;
    }
}