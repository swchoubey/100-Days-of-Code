class Solution {
    public int maxScore(String s) {
        int maxScore=0;
        for(int i=1;i<s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i, s.length());
            int score=0;
            for(char c : left.toCharArray()){
                if(c=='0'){
                    ++score;
                }
            }
            for(char c: right.toCharArray()){
                if(c=='1'){
                    ++score;
                }
            }
            maxScore=Math.max(maxScore, score);
        }
        return maxScore;
    }
}