class Solution {
    public int maxScore(String s) {
        int ones=0;
        int zScore=s.charAt(0)=='0'?1:0;
        int score=zScore;
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                zScore++;
            }
            else{
                ones++;
                zScore-=1;
            }
            if(zScore>score){
                score=zScore;
            }
        }
        ones+=(s.charAt(s.length()-1)=='1'?1:0);

        return ones+score;
    }
}