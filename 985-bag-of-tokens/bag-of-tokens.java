class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int s = 0, max = 0, l = 0, r = tokens.length - 1;

        while(l <= r){
            if(power >= tokens[l]){
                power -= tokens[l];
                s++;
                l++;
                max = Math.max(max, s);
            }
            else if(s > 0) {
                power += tokens[r];
                s--;
                r--;
            }
            else{
                break;
            }
        }
        return max;
    }
}