class Solution {
    public String reversePrefix(String word, char ch) {
        int cInd = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ch){
                cInd = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(word.substring(0, cInd+1));
        sb.reverse().append(word.substring(cInd + 1, word.length()));

        return sb.toString();
    }
}